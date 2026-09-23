# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/creditsystem/gestioncreditos/bdd/steps/SolicitudCreditoSteps.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/resources/features/solicitud_credito.feature` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/creditsystem/gestioncreditos/bdd/CucumberTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/creditsystem/gestioncreditos/application/usecases/RegistrarSolicitudCreditoUseCaseTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/creditsystem/gestioncreditos/infrastructure/adapters/SolicitudCreditoJpaRepositoryTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoController.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getMotorRiesgoUrl`: Se invoca `getMotorRiesgoUrl` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getMaxRequestsPerSecond`: Se invoca `getMaxRequestsPerSecond` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getIdempotencyWindowHours`: Se invoca `getIdempotencyWindowHours` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getConnectTimeout`: Se invoca `getConnectTimeout` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getReadTimeout`: Se invoca `getReadTimeout` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getEnvironment`: Se invoca `getEnvironment` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoController.java` — `RegistrarSolicitudCreditoUseCase.registrarSolicitud`: Se invoca `registrarSolicitud` sobre `RegistrarSolicitudCreditoUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/creditsystem/gestioncreditos/bdd/steps/SolicitudCreditoSteps.java` — `SolicitudCredito.getEstado`: Se invoca `getEstado` sobre `SolicitudCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/creditsystem/gestioncreditos/application/usecases/RegistrarSolicitudCreditoUseCaseTest.java` — `RegistrarSolicitudCreditoUseCase.registrarSolicitudCredito`: Se invoca `registrarSolicitudCredito` sobre `RegistrarSolicitudCreditoUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/creditsystem/gestioncreditos/infrastructure/adapters/SolicitudCreditoJpaRepositoryTest.java` — `SolicitudCreditoJpaRepository.save`: Se invoca `save` sobre `SolicitudCreditoJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoControllerTest.java` — `SolicitudCreditoJpaRepository.save`: Se invoca `save` sobre `SolicitudCreditoJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoControllerTest.java` — `SolicitudCreditoController.registrarSolicitudCredito`: Se invoca `registrarSolicitudCredito` sobre `SolicitudCreditoController`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced

### Brecha de conocimiento
Aplica metodologías de desarrollo basadas en comportamiento como BDD (Desarrollo Guiado por Comportamiento) y trabaja bajo herramientas de automatización como Cucumber, el framework Karate, etc.

### Misión / candidato
Candidato con experiencia avanzada en backend, trabajando en equipo distribuido, con sólida base en arquitectura y testing.

### Reto
- Tema: Desarrollador con Sólida Experiencia en BDD y Frameworks de Automatización
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de BDD en un Sistema de Gestión de Créditos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición de Escenarios de BDD — objetivo: Establecer los escenarios de comportamiento esperado para el sistema de gestión de créditos. — entregable (NO resolver): Documento de escenarios de BDD con criterios de aceptación definidos.
- Fase 2: Automatización de Escenarios con BDD — objetivo: Automatizar los escenarios definidos en la fase anterior utilizando BDD. — entregable (NO resolver): Escenarios de BDD automatizados y ejecutables.
- Fase 3: Integración y Validación — objetivo: Integrar y validar los escenarios automatizados en el sistema de gestión de créditos. — entregable (NO resolver): Escenarios automatizados integrados y validados en el sistema de gestión de créditos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.creditsystem</groupId>
    <artifactId>gestion-creditos</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>gestion-creditos</name>
    <description>Sistema de gestión de créditos con BDD y Spring Boot</description>

    <properties>
        <java.version>21</java.version>
        <cucumber.version>7.15.0</cucumber.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Base de datos -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-spring</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                        <include>**/*Steps.java</include>
                        <include>**/CucumberTest.java</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java ===
package com.creditsystem.gestioncreditos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;

import java.time.Duration;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties
public class GestionCreditosApplication {

    private final ApplicationProperties applicationProperties;

    public GestionCreditosApplication(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
        validateProperties();
    }

    private void validateProperties() {
        if (applicationProperties.getMotorRiesgoUrl() == null || applicationProperties.getMotorRiesgoUrl().isBlank()) {
            throw new IllegalStateException("La URL del motor de riesgo no puede estar vacía");
        }
        if (applicationProperties.getMaxRequestsPerSecond() <= 0) {
            throw new IllegalStateException("El número máximo de solicitudes por segundo debe ser positivo");
        }
        if (applicationProperties.getIdempotencyWindowHours() <= 0) {
            throw new IllegalStateException("La ventana de idempotencia debe ser positiva");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionCreditosApplication.class, args);
    }

    @Bean
    @Primary
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(applicationProperties.getConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(applicationProperties.getReadTimeout()))
                .build();
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags(
                "application", "gestion-creditos",
                "environment", applicationProperties.getEnvironment()
        );
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("\n==================================================");
            System.out.println("Sistema de Gestión de Créditos iniciado con éxito");
            System.out.println("Ambiente: " + applicationProperties.getEnvironment());
            System.out.println("Motor de Riesgo: " + applicationProperties.getMotorRiesgoUrl());
            System.out.println("Límite de solicitudes por segundo: " + applicationProperties.getMaxRequestsPerSecond());
            System.out.println("Ventana de idempotencia: " + applicationProperties.getIdempotencyWindowHours() + " horas");
            System.out.println("==================================================\n");
        };
    }
}

record ApplicationProperties(
        String motorRiesgoUrl,
        int maxRequestsPerSecond,
        int idempotencyWindowHours,
        String environment,
        long connectTimeout,
        long readTimeout) {}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: gestion-creditos
  profiles:
    active: dev
  datasource:
    url: jdbc:h2:mem:gestioncreditos;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driver-class-name: org.h2.Driver
    username: sa
    password: ""
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        web-allow-others: true
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        use_sql_comments: true
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true

server:
  port: 8080
  servlet:
    context-path: /api/creditos
  tomcat:
    threads:
      max: 200
    connection-timeout: 5000ms

application:
  motor-riesgo-url: "http://localhost:8081/api/evaluar-riesgo"
  max-requests-per-second: 1500
  idempotency-window-hours: 24
  environment: dev
  connect-timeout: 500
  read-timeout: 2000

logging:
  level:
    root: INFO
    com.creditsystem.gestioncreditos: DEBUG
    org.springframework.web: INFO
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
  pattern:
    console: "%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(%5p) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40c{1.}){cyan} %clr(:){faint} %m%n%wEx"

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  endpoint:
    health:
      show-details: always
  metrics:
    tags:
      application: ${spring.application.name}

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/domain/models/SolicitudCredito.java ===
package com.creditsystem.gestioncreditos.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record SolicitudCredito(
        UUID id,
        String numeroOperacion,
        String canal,
        String tipoDocumento,
        String numeroDocumento,
        String nombreSolicitante,
        String apellidoSolicitante,
        BigDecimal montoSolicitado,
        Integer plazoMeses,
        BigDecimal tasaInteres,
        String estado,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion,
        String resultadoRiesgo,
        String codigoRiesgo,
        String descripcionRiesgo) {

    public static final String ESTADO_PENDIENTE = "PENDIENTE";
    public static final String ESTADO_APROBADO = "APROBADO";
    public static final String ESTADO_RECHAZADO = "RECHAZADO";
    public static final String ESTADO_ERROR = "ERROR";

    public SolicitudCredito {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la solicitud no puede ser nulo");
        }
        if (numeroOperacion == null || numeroOperacion.isBlank()) {
            throw new IllegalArgumentException("El número de operación no puede ser nulo o vacío");
        }
        if (canal == null || canal.isBlank()) {
            throw new IllegalArgumentException("El canal no puede ser nulo o vacío");
        }
        if (montoSolicitado == null || montoSolicitado.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto solicitado debe ser mayor que cero");
        }
        if (plazoMeses == null || plazoMeses <= 0) {
            throw new IllegalArgumentException("El plazo en meses debe ser mayor que cero");
        }
        if (tasaInteres == null || tasaInteres.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("La tasa de interés debe ser mayor que cero");
        }
        if (estado == null || estado.isBlank()) {
            estado = ESTADO_PENDIENTE;
        }
        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now();
        }
        if (fechaActualizacion == null) {
            fechaActualizacion = LocalDateTime.now();
        }
    }

    public SolicitudCredito conResultadoRiesgo(String resultadoRiesgo, String codigoRiesgo, String descripcionRiesgo) {
        return new SolicitudCredito(
                this.id,
                this.numeroOperacion,
                this.canal,
                this.tipoDocumento,
                this.numeroDocumento,
                this.nombreSolicitante,
                this.apellidoSolicitante,
                this.montoSolicitado,
                this.plazoMeses,
                this.tasaInteres,
                resultadoRiesgo.equals("APROBADO") ? ESTADO_APROBADO : ESTADO_RECHAZADO,
                this.fechaCreacion,
                LocalDateTime.now(),
                resultadoRiesgo,
                codigoRiesgo,
                descripcionRiesgo
        );
    }

    public SolicitudCredito conEstado(String nuevoEstado) {
        return new SolicitudCredito(
                this.id,
                this.numeroOperacion,
                this.canal,
                this.tipoDocumento,
                this.numeroDocumento,
                this.nombreSolicitante,
                this.apellidoSolicitante,
                this.montoSolicitado,
                this.plazoMeses,
                this.tasaInteres,
                nuevoEstado,
                this.fechaCreacion,
                LocalDateTime.now(),
                this.resultadoRiesgo,
                this.codigoRiesgo,
                this.descripcionRiesgo
        );
    }

    public String generarClaveIdempotencia() {
        return numeroOperacion + "|" + canal;
    }
}

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/domain/ports/SolicitudCreditoRepository.java ===
package com.creditsystem.gestioncreditos.domain.ports;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import java.util.Optional;
import java.util.UUID;

public interface SolicitudCreditoRepository {
    SolicitudCredito save(SolicitudCredito solicitudCredito);
    
    Optional<SolicitudCredito> findById(UUID id);
    
    Optional<SolicitudCredito> findByNumeroOperacionAndCanal(String numeroOperacion, String canal);
    
    Optional<SolicitudCredito> findByClaveIdempotencia(String claveIdempotencia);
}

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/domain/ports/MotorRiesgoService.java ===
package com.creditsystem.gestioncreditos.domain.ports;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import java.util.concurrent.CompletableFuture;

public interface MotorRiesgoService {
    CompletableFuture<EvaluacionRiesgo> evaluarRiesgo(SolicitudCredito solicitudCredito);
    
    record EvaluacionRiesgo(
            String resultado,
            String codigo,
            String descripcion) {
    }
}

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/infrastructure/adapters/SolicitudCreditoJpaRepository.java ===
package com.creditsystem.gestioncreditos.infrastructure.adapters;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SolicitudCreditoJpaRepository extends JpaRepository<SolicitudCredito, UUID>, SolicitudCreditoRepository {
    Optional<SolicitudCredito> findByNumeroOperacionAndCanal(String numeroOperacion, String canal);
    Optional<SolicitudCredito> findByClaveIdempotencia(String claveIdempotencia);
}

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/application/usecases/RegistrarSolicitudCreditoUseCase.java ===
package com.creditsystem.gestioncreditos.application.usecases;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import com.creditsystem.gestioncreditos.domain.ports.MotorRiesgoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.concurrent.CompletableFuture;

@Service
public class RegistrarSolicitudCreditoUseCase {
    private final SolicitudCreditoRepository solicitudCreditoRepository;
    private final MotorRiesgoService motorRiesgoService;

    public RegistrarSolicitudCreditoUseCase(SolicitudCreditoRepository solicitudCreditoRepository, MotorRiesgoService motorRiesgoService) {
        this.solicitudCreditoRepository = solicitudCreditoRepository;
        this.motorRiesgoService = motorRiesgoService;
    }

    @Transactional
    public CompletableFuture<SolicitudCredito> registrar(SolicitudCredito solicitudCredito) {
        SolicitudCredito savedSolicitud = solicitudCreditoRepository.save(solicitudCredito);
        return motorRiesgoService.evaluarRiesgo(savedSolicitud).thenApply(evaluacionRiesgo -> {
            savedSolicitud.conResultadoRiesgo(evaluacionRiesgo.getEstadoRiesgo(), evaluacionRiesgo.getCodigoRiesgo(), evaluacionRiesgo.getDescripcionRiesgo());
            return solicitudCreditoRepository.save(savedSolicitud);
        });
    }
}

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/infrastructure/adapters/MotorRiesgoRestClient.java ===
package com.creditsystem.gestioncreditos.infrastructure.adapters;


import com.creditsystem.gestioncreditos.domain.ports.EvaluacionRiesgo;
import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.MotorRiesgoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;

@Service
public class MotorRiesgoRestClient implements MotorRiesgoService {

    private final RestTemplate restTemplate;
    private final String motorRiesgoUrl;

    public MotorRiesgoRestClient(RestTemplate restTemplate, @Value("${motor-riesgo.url}") String motorRiesgoUrl) {
        this.restTemplate = restTemplate;
        this.motorRiesgoUrl = motorRiesgoUrl;
    }

    @Override
    public CompletableFuture<MotorRiesgoService.EvaluacionRiesgo> evaluarRiesgo(SolicitudCredito solicitudCredito) {
        return CompletableFuture.supplyAsync(() -> {
            // Simula la llamada al servicio de riesgo externo
            return new MotorRiesgoService.EvaluacionRiesgo("Aprobado", "001", "Riesgo bajo");
        });
    }
}

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoController.java ===
package com.creditsystem.gestioncreditos.infrastructure.controllers;


import com.creditsystem.gestioncreditos.domain.ports.EvaluacionRiesgo;
import com.creditsystem.gestioncreditos.application.usecases.RegistrarSolicitudCreditoUseCase;
import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.MotorRiesgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/creditos")
public class SolicitudCreditoController {

    private final RegistrarSolicitudCreditoUseCase registrarSolicitudCreditoUseCase;
    private final MotorRiesgoService motorRiesgoService;

    @Autowired
    public SolicitudCreditoController(RegistrarSolicitudCreditoUseCase registrarSolicitudCreditoUseCase, MotorRiesgoService motorRiesgoService) {
        this.registrarSolicitudCreditoUseCase = registrarSolicitudCreditoUseCase;
        this.motorRiesgoService = motorRiesgoService;
    }

    @PostMapping
    public ResponseEntity<SolicitudCredito> registrarSolicitud(@Valid @RequestBody SolicitudCredito solicitudCredito) {
        Mono<SolicitudCredito> solicitudRegistrada = registrarSolicitudCreditoUseCase.registrarSolicitud(solicitudCredito);
        solicitudRegistrada.subscribe(s -> solicitudCredito.conEstado(SolicitudCredito.ESTADO_PENDIENTE));
        Mono<MotorRiesgoService.EvaluacionRiesgo> evaluacionRiesgo = motorRiesgoService.evaluarRiesgo(solicitudCredito);
        evaluacionRiesgo.subscribe(e -> solicitudCredito.conResultadoRiesgo(e.resultadoRiesgo(), e.codigoRiesgo(), e.descripcionRiesgo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudCredito);
    }
}

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/infrastructure/config/CucumberConfig.java ===
package com.creditsystem.gestioncreditos.infrastructure.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
public class CucumberConfig {

}

// === ARCHIVO: src/main/java/com/creditsystem/gestioncreditos/infrastructure/exceptions/GlobalExceptionHandler.java ===
package com.creditsystem.gestioncreditos.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor: " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Argumento inválido: " + ex.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error de puntero nulo: " + ex.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error de validación: " + ex.getMessage());
    }
}

// === ARCHIVO: src/test/java/com/creditsystem/gestioncreditos/bdd/steps/SolicitudCreditoSteps.java ===
package com.creditsystem.gestioncreditos.bdd.steps;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolicitudCreditoSteps {

    @Autowired
    private SolicitudCreditoRepository solicitudCreditoRepository;

    private SolicitudCredito solicitudCredito;

    @Given("una solicitud de crédito con número de operación {string}")
    public void unaSolicitudDeCreditoConNumeroDeOperacion(String numeroOperacion) {
        solicitudCredito = new SolicitudCredito(numeroOperacion);
    }

    @When("se registra la solicitud")
    public void seRegistraLaSolicitud() {
        solicitudCreditoRepository.save(solicitudCredito);
    }

    @Then("la solicitud debe estar en estado {string}")
    public void laSolicitudDebeEstarEnEstado(String estado) {
        assertEquals(estado, solicitudCredito.getEstado());
    }
}

// === ARCHIVO: src/test/resources/features/solicitud_credito.feature ===
Feature: Gestión de solicitudes de crédito

  Scenario: Registrar una solicitud de crédito
    Given una solicitud de crédito con número de operación "123456"
    When se registra la solicitud
    Then la solicitud debe estar en estado "PENDIENTE"

// === ARCHIVO: src/test/java/com/creditsystem/gestioncreditos/bdd/CucumberTest.java ===
package com.creditsystem.gestioncreditos.bdd;

import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.junit.platform.engine.Cucumber;

@CucumberContextConfiguration
@SpringBootTest
@Cucumber
public class CucumberTest {
    // No se implementa nada aquí, es solo un marcador para ejecutar los tests de BDD
}

// === ARCHIVO: src/test/java/com/creditsystem/gestioncreditos/application/usecases/RegistrarSolicitudCreditoUseCaseTest.java ===
package com.creditsystem.gestioncreditos.application.usecases;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import com.creditsystem.gestioncreditos.domain.ports.MotorRiesgoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrarSolicitudCreditoUseCaseTest {

    @Mock
    private SolicitudCreditoRepository solicitudCreditoRepository;

    @Mock
    private MotorRiesgoService motorRiesgoService;

    @InjectMocks
    private RegistrarSolicitudCreditoUseCase registrarSolicitudCreditoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrarSolicitudCredito() {
        // Arrange
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        when(solicitudCreditoRepository.save(any(SolicitudCredito.class))).thenReturn(solicitudCredito);

        // Act
        SolicitudCredito result = registrarSolicitudCreditoUseCase.registrarSolicitudCredito(solicitudCredito);

        // Assert
        assertNotNull(result);
        verify(solicitudCreditoRepository, times(1)).save(any(SolicitudCredito.class));
    }
}

// === ARCHIVO: src/test/java/com/creditsystem/gestioncreditos/infrastructure/adapters/SolicitudCreditoJpaRepositoryTest.java ===
package com.creditsystem.gestioncreditos.infrastructure.adapters;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudCreditoJpaRepositoryTest {

    @Mock
    private SolicitudCreditoRepository solicitudCreditoRepository;

    @InjectMocks
    private SolicitudCreditoJpaRepository solicitudCreditoJpaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveSolicitudCredito() {
        // Arrange
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        when(solicitudCreditoRepository.save(any(SolicitudCredito.class))).thenReturn(solicitudCredito);

        // Act
        SolicitudCredito result = solicitudCreditoJpaRepository.save(solicitudCredito);

        // Assert
        assertNotNull(result);
        verify(solicitudCreditoRepository, times(1)).save(any(SolicitudCredito.class));
    }
}

// === ARCHIVO: src/test/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoControllerTest.java ===
package com.creditsystem.gestioncreditos.infrastructure.controllers;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.infrastructure.adapters.SolicitudCreditoJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudCreditoControllerTest {

    @Mock
    private SolicitudCreditoJpaRepository solicitudCreditoJpaRepository;

    @InjectMocks
    private SolicitudCreditoController solicitudCreditoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrarSolicitudCredito() {
        // Arrange
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        when(solicitudCreditoJpaRepository.save(any(SolicitudCredito.class))).thenReturn(solicitudCredito);

        // Act
        SolicitudCredito result = solicitudCreditoController.registrarSolicitudCredito(solicitudCredito);

        // Assert
        assertNotNull(result);
        verify(solicitudCreditoJpaRepository, times(1)).save(any(SolicitudCredito.class));
    }
}
```
