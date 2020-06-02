1. create the Project  --> STS--> new --> maven Project
2. create the schemas  --> copy from the resources or you can create the new xsd file
3. use the jaxb Plugin  -> add the jaxB plugins from the pom.xml present in resources OR you can take it from maven repository
4. generate the stubs and use them. --> after adding the plugins in pom.xml and save it --> go to project --> run as--> Maven generate-sources
