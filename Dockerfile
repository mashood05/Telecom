FROM openjdk:11
ADD target/telecom.jar telecom.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","telecom.jar"]