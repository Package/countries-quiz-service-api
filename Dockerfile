FROM openjdk:11

COPY . .

# Clean Build
RUN ./mvnw clean package -DskipTests

# Copy built JAR
RUN cp target/country-api-0.0.1-SNAPSHOT.jar ./API.jar

ENTRYPOINT ["java", "-jar", "API.jar"]