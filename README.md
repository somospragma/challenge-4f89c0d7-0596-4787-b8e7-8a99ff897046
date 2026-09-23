# Implementación de BDD en un Sistema de Gestión de Créditos

En el contexto de un sistema de gestión de créditos en una institución financiera, debes aplicar BDD para definir y automatizar el comportamiento esperado del sistema. El sistema debe manejar solicitudes de crédito, validar la información del solicitante, y comunicarse con un motor de riesgo para obtener una evaluación. Los actores involucrados son el 'originador de créditos', el'motor antifraude', y el 'buró de riesgos'. El sistema debe procesar un mínimo de 1 500 solicitudes por segundo en hora pico y mantener una consistencia de datos entre la solicitud y la evaluación de riesgo. La idempotencia del registro de la solicitud se garantiza por el número de operación y el canal, asegurando que dos invocaciones con la misma clave produzcan un solo registro y devuelvan la misma respuesta dentro de 24 horas.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Desarrollador con Sólida Experiencia en BDD y Frameworks de Automatización |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición de Escenarios de BDD

**Objetivo:** Establecer los escenarios de comportamiento esperado para el sistema de gestión de créditos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identifica y documenta los escenarios de comportamiento esperado para el proceso de solicitud y evaluación de créditos.
- Define criterios de aceptación para cada escenario, asegurando la consistencia y la idempotencia del registro de solicitudes.

**Entregable:** Documento de escenarios de BDD con criterios de aceptación definidos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los diferentes estados que puede tener una solicitud de crédito y las transiciones entre ellos.
- Piensa en cómo el sistema debe comportarse ante diferentes entradas y condiciones de error.

</details>

### Fase 2: Automatización de Escenarios con BDD

**Objetivo:** Automatizar los escenarios definidos en la fase anterior utilizando BDD.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa los escenarios de BDD utilizando un framework de automatización como Cucumber o Karate.
- Asegura que cada escenario se ejecute correctamente y que los criterios de aceptación se cumplan.

**Entregable:** Escenarios de BDD automatizados y ejecutables.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza la sintaxis Gherkin para escribir tus escenarios.
- Prueba diferentes entradas y condiciones de error para asegurar la robustez de tu implementación.

</details>

### Fase 3: Integración y Validación

**Objetivo:** Integrar y validar los escenarios automatizados en el sistema de gestión de créditos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Integra los escenarios automatizados en el sistema de gestión de créditos.
- Realiza pruebas de integración para asegurar que los escenarios se comportan como se espera en el contexto del sistema completo.
- Documenta cualquier hallazgo o mejora necesaria.

**Entregable:** Escenarios automatizados integrados y validados en el sistema de gestión de créditos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo los escenarios interactúan con otros componentes del sistema.
- Piensa en posibles mejoras o ajustes necesarios para asegurar la consistencia y la eficiencia del sistema.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es BDD y cómo se aplica en el contexto de un sistema de gestión de créditos?
- **paraQueSirve**: ¿Para qué sirve aplicar BDD en el desarrollo de un sistema de gestión de créditos?
- **comoSeUsa**: ¿Cómo se usa BDD para definir y automatizar escenarios de comportamiento en un sistema de gestión de créditos?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar BDD en un sistema de gestión de créditos y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la aplicación de BDD en un sistema de gestión de créditos y cómo se justifican?

## Criterios de Evaluacion

- Definición clara y completa de escenarios de BDD.
- Automatización exitosa de escenarios utilizando un framework de automatización.
- Integración y validación efectiva de escenarios automatizados en el sistema de gestión de créditos.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
