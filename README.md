# Running Section Extractor Service

## Java 
* Verify Java 12 is installed. Currently openjdk, however Oracle JDK 12 will be released shortly
* Make sure that 
    * JAVA_HOME is set to Java 12 JDK
    * PATH variable has Java 12 path at the beginning
* verification

`java -version`

should return:   
java version "12" 2019-03-19
Java(TM) SE Runtime Environment (build 12+33)
Java HotSpot(TM) 64-Bit Server VM (build 12+33, mixed mode, sharing)
(or a later version)

## Required Environment Variables


## Database / MySQL 
* None at this point but will be added (and flyway migrations setup at that time)

## Running from Eclipse
* verify that `JRE System Library` in the `Package Explorer` is pointing to JavaSE-11 or 12
* Run -> Run Configurations -> JRE tab -> Runtime JRE should be JavaSE-11 or 12
* If you don't see Java 12 in the screen above, make sure to install this plugin https://marketplace.eclipse.org/content/java-12-support-eclipse-2019-03-411

## Running from commandline using `mvn`
* verify mvn version to be 3.5 or later
* [Use instructions in Apache Maven Site](https://maven.apache.org/install.html)
* Make sure that `MAVEN_HOME` is set and is pointing to right `JAVA_HOME`
* To run
`mvn clean package spring-boot:run`
* add `-DskipTests` if you don't want tests to be run as well
* or
`java -jar target/sectionextractor-0.0.1-SNAPSHOT.jar`

## Code coverage
* eclipse use: https://www.eclemma.org/
* mvn
`mvn clean test`
* check target/site/jacoco/index.html and for further info: https://www.mkyong.com/maven/maven-jacoco-code-coverage-example/
* to fail build if it doesn't satisfy code coverage percentage run
`mvn clean test verify`


