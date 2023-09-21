# Lia Cardoso - 107548
# Study Notebook - Lab 1
# 
# Aula 2
# --> Docker
# ---> Wrapping-up

mvn archetype:generate -DgroupId=org.example -DartifactId=MyWeatherRadar -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


### Sincronizar o maven

$ mvn clean
$ mvn clean package
$ mvn install


### Correr o projeto

$ mvn compile exec:java -Dexec.mainClass="org.example.WeatherStarter"
