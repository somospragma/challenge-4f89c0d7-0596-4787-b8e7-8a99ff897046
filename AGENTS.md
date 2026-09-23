# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de BDD en un Sistema de Gestión de Créditos**.

| | |
|---|---|
| Tema | Desarrollador con Sólida Experiencia en BDD y Frameworks de Automatización |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- com.h2database:h2 2.2.224
- io.cucumber:cucumber-java 7.15.0
- io.cucumber:cucumber-spring 7.15.0
- org.springframework.boot:spring-boot-starter-test n/a
- org.junit.jupiter:junit-jupiter-api n/a
- org.mockito:mockito-core 5.11.0
- org.mockito:mockito-junit-jupiter 5.11.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición de Escenarios de BDD**: Documento de escenarios de BDD con criterios de aceptación definidos.
- **Fase 2 — Automatización de Escenarios con BDD**: Escenarios de BDD automatizados y ejecutables.
- **Fase 3 — Integración y Validación**: Escenarios automatizados integrados y validados en el sistema de gestión de créditos.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/test/java/com/creditsystem/gestioncreditos/bdd/steps/SolicitudCreditoSteps.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/resources/features/solicitud_credito.feature` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/creditsystem/gestioncreditos/bdd/CucumberTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/creditsystem/gestioncreditos/application/usecases/RegistrarSolicitudCreditoUseCaseTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/creditsystem/gestioncreditos/infrastructure/adapters/SolicitudCreditoJpaRepositoryTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (13)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoController.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getMotorRiesgoUrl`
      Se invoca `getMotorRiesgoUrl` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getMaxRequestsPerSecond`
      Se invoca `getMaxRequestsPerSecond` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getIdempotencyWindowHours`
      Se invoca `getIdempotencyWindowHours` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getConnectTimeout`
      Se invoca `getConnectTimeout` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getReadTimeout`
      Se invoca `getReadTimeout` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java` — `ApplicationProperties.getEnvironment`
      Se invoca `getEnvironment` sobre `ApplicationProperties`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoController.java` — `RegistrarSolicitudCreditoUseCase.registrarSolicitud`
      Se invoca `registrarSolicitud` sobre `RegistrarSolicitudCreditoUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/creditsystem/gestioncreditos/bdd/steps/SolicitudCreditoSteps.java` — `SolicitudCredito.getEstado`
      Se invoca `getEstado` sobre `SolicitudCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/creditsystem/gestioncreditos/application/usecases/RegistrarSolicitudCreditoUseCaseTest.java` — `RegistrarSolicitudCreditoUseCase.registrarSolicitudCredito`
      Se invoca `registrarSolicitudCredito` sobre `RegistrarSolicitudCreditoUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/creditsystem/gestioncreditos/infrastructure/adapters/SolicitudCreditoJpaRepositoryTest.java` — `SolicitudCreditoJpaRepository.save`
      Se invoca `save` sobre `SolicitudCreditoJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoControllerTest.java` — `SolicitudCreditoJpaRepository.save`
      Se invoca `save` sobre `SolicitudCreditoJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoControllerTest.java` — `SolicitudCreditoController.registrarSolicitudCredito`
      Se invoca `registrarSolicitudCredito` sobre `SolicitudCreditoController`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (18)

- `pom.xml`
- `src/main/java/com/creditsystem/gestioncreditos/GestionCreditosApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/creditsystem/gestioncreditos/domain/models/SolicitudCredito.java`
- `src/main/java/com/creditsystem/gestioncreditos/domain/ports/SolicitudCreditoRepository.java`
- `src/main/java/com/creditsystem/gestioncreditos/domain/ports/MotorRiesgoService.java`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/adapters/SolicitudCreditoJpaRepository.java`
- `src/main/java/com/creditsystem/gestioncreditos/application/usecases/RegistrarSolicitudCreditoUseCase.java`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/adapters/MotorRiesgoRestClient.java`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoController.java`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/config/CucumberConfig.java`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/exceptions/GlobalExceptionHandler.java`
- `src/test/java/com/creditsystem/gestioncreditos/bdd/steps/SolicitudCreditoSteps.java`
- `src/test/resources/features/solicitud_credito.feature`
- `src/test/java/com/creditsystem/gestioncreditos/bdd/CucumberTest.java`
- `src/test/java/com/creditsystem/gestioncreditos/application/usecases/RegistrarSolicitudCreditoUseCaseTest.java`
- `src/test/java/com/creditsystem/gestioncreditos/infrastructure/adapters/SolicitudCreditoJpaRepositoryTest.java`
- `src/test/java/com/creditsystem/gestioncreditos/infrastructure/controllers/SolicitudCreditoControllerTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/creditsystem/gestioncreditos`
- `src/main/java/com/creditsystem/gestioncreditos/domain`
- `src/main/java/com/creditsystem/gestioncreditos/domain/models`
- `src/main/java/com/creditsystem/gestioncreditos/domain/ports`
- `src/main/java/com/creditsystem/gestioncreditos/application`
- `src/main/java/com/creditsystem/gestioncreditos/application/usecases`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/adapters`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/controllers`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/config`
- `src/main/java/com/creditsystem/gestioncreditos/infrastructure/exceptions`
- `src/test/java/com/creditsystem/gestioncreditos`
- `src/test/java/com/creditsystem/gestioncreditos/bdd`
- `src/test/resources`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced
- Brecha que el reto ataca: Aplica metodologías de desarrollo basadas en comportamiento como BDD (Desarrollo Guiado por Comportamiento) y trabaja bajo herramientas de automatización como Cucumber, el framework Karate, etc.
- Mision: Candidato con experiencia avanzada en backend, trabajando en equipo distribuido, con sólida base en arquitectura y testing.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
