FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY  bff-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENV JAEGER_SERVICE_NAME=userapp\
  JAEGER_ENDPOINT=http://jaeger-collector.istio-system.svc:14268/api/traces\
  JAEGER_PROPAGATION=b3\
  JAEGER_SAMPLER_TYPE=const\
  JAEGER_SAMPLER_PARAM=1
EXPOSE 8080/tcp
