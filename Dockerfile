FROM java:8
VOLUME /tmp
ADD target/loanbroker-rulebase-1.0-SNAPSHOT.jar app.jar
ADD src/main/xsd xsd
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java" ,"-jar", "/app.jar"]
