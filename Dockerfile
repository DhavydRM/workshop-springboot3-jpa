# Imagem oficial do Eclipse Temurin para Java 21
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copia o JAR gerado (ajuste se usar nome personalizado)
COPY target/course-0.0.1-SNAPSHOT.jar app.jar

# Configuração de tempo de execução otimizado para containers
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]