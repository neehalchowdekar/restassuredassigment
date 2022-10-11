FROM neehalqa/java8-3.6.3-testdp
copy src home/apiframework/src
copy test-output/index.html home/apiframework/index.html
copy pom.xml home/apiframework/pom.xml
copy testng.xml home/apiframework/testng.xml
WORKDIR home/apiframework
ENTRYPOINT mvn clean test