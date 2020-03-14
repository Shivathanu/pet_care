FROM openjdk:8-jdk-alpine
WORKDIR /target 
COPY ./target/*.war  /target/petcare.war
ENTRYPOINT ["java","-jar","petcare.war"]

# Make port 8080 available to the world outside this container
# EXPOSE 8080
