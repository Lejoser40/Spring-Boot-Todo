FROM openjdk:21-jdk-slim

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Directorio de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY . .

# Compilar aplicación
RUN mvn clean package -DskipTests

# Exponer puerto
EXPOSE 8080

# Ejecutar aplicación
CMD ["java", "-jar", "target/TodoList-0.0.1-SNAPSHOT.jar"]
