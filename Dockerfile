FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/servicio-breeds-0.1.jar servicio-breeds.jar
ENTRYPOINT ["java","-jar","/servicio-breeds.jar"]