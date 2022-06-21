FROM openjdk:11
VOLUME /tmp
EXPOSE 8094
ADD ./target/ws-product-pasive-0.0.1-SNAPSHOT.jar ws-product-pasive.jar
ENTRYPOINT ["java","-jar","ws-product-pasive.jar"]