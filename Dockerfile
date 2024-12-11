FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Copiar el archivo JAR generado al contenedor
COPY target/bootcamp-product-type-service-0.0.1-SNAPSHOT.jar app.jar
# Exponer el puerto que usa tu aplicación (por defecto es 8080)
EXPOSE 8030
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]