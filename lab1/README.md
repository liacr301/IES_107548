# Lia Cardoso - 107548
# Study Notebook - Lab 1
# 
# Aula 2
# --> Docker
# ---> Wrapping-up

mvn archetype:generate -DgroupId=ua.deti.ies -DartifactId=lab1 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


### Sincronizar o maven

$ mvn clean
$ mvn clean package
$ mvn install


### Correr o projeto

$ mvn compile exec:java -Dexec.mainClass="ua.deti.ies.lab1.App"