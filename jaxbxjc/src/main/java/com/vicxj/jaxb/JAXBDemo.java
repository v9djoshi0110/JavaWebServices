package com.vicxj.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.vicxj.patient.Gender;
import com.vicxj.patient.Patient;
import com.vicxj.patient.PaymentType;

public class JAXBDemo {

	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);

			// marshalling
			Marshaller marshaller = context.createMarshaller();

			Patient patient = new Patient();
			patient.setAge(45);
			patient.setId(43);
			patient.setName("Vinod");
			patient.setGender(Gender.M);
			PaymentType paymentType = new PaymentType();
			paymentType.setCash(2343);
			patient.setPayment(paymentType);

			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);

			System.out.println(writer.toString());

			// Unmarshalling
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Patient patientUnmarshall = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
			System.out.println(patient.getName() + " have paid $" + patient.getPayment().getCash());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
