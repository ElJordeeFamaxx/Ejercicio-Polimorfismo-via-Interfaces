# Ejercicio 6: Dashboard modular

## Datos del estudiante

- **Nombre:** [Tu nombre completo]
- **Carné:** [Tu carné]
- **Curso:** CC2008 – Programación Orientada a Objetos
- **Semestre:** II, 2026

## Descripción

Aplicación desarrollada en Java que administra un dashboard con diferentes
tipos de widgets: clima, relojes, tareas pendientes, alertas y notas.

El proyecto aplica herencia, polimorfismo mediante interfaces y el patrón
Modelo-Vista-Controlador (MVC). Todos los widgets se almacenan en una
única lista polimórfica de tipo `List<Widget>`.

## Funcionalidades

- Carga inicial de diez widgets.
- Listado de widgets activos.
- Búsqueda por ID o nombre exacto, sin distinguir mayúsculas.
- Consulta de configuración y contenido.
- Ordenamiento ascendente por consumo estimado de memoria en KB.
- Interacción con tareas y alertas.
- Actualización automática cada cinco segundos.
- Interfaz gráfica desarrollada con Swing.

## Requisitos

- JDK 17 o superior.
- Un entorno con escritorio gráfico.
- Para trabajar en VS Code: Extension Pack for Java.

No se necesitan bibliotecas externas.

## Organización del programa

| Archivo | Responsabilidad |
|---------|-----------------|
| Renderizable.java | Define el comportamiento de renderizado. |
| Interactivo.java | Define la respuesta a clics. |
| Actualizable.java | Define la actualización del contenido. |
| Widget.java | Clase abstracta con los atributos comunes. |
| Clima.java | Muestra temperaturas simuladas. |
| Reloj.java | Muestra la hora de una zona horaria. |
| Tareas.java | Administra una cantidad de tareas pendientes. |
| Alerta.java | Muestra una notificación y permite marcarla como leída. |
| Nota.java | Muestra información estática. |
| Dashboard.java | Administra la lista, las búsquedas y el ordenamiento. |
| Catalogo.java | Crea los diez widgets iniciales. |
| VistaDashboard.java | Define el contrato de la vista. |
| Controlador.java | Coordina las acciones entre modelo y vista. |
| Principal.java | Implementa la interfaz gráfica y contiene el método main. |

Todos los archivos Java se encuentran dentro de la carpeta `src`.

## Ejecución

### Desde VS Code

1. Abrir la carpeta principal del proyecto.
2. Abrir `src/Principal.java`.
3. Ejecutar el método `main` mediante la opción **Run Java**.

### Desde la terminal

Ejecutar estos comandos desde la carpeta principal del proyecto:


javac -encoding UTF-8 -d bin *.java
java -cp bin Principal


## Uso

1. Presionar **Listar activos** para visualizar los widgets.
2. Elegir **ID** o **Nombre**, escribir la consulta y presionar **Buscar**.
3. Presionar **Ordenar por KB** para ordenar por memoria.
4. Seleccionar una fila y presionar **Interactuar**:
   - Tareas: completa una tarea pendiente.
   - Alerta: marca la notificación como leída.
   - Otros widgets: muestran un aviso indicando que no admiten clics.
5. Presionar **Actualizar** para refrescar el contenido.
6. Presionar **Salir** para cerrar el programa.

## Conceptos aplicados

- **Herencia:** los widgets concretos extienden la clase `Widget`.
- **Interfaces:** `Renderizable`, `Interactivo` y `Actualizable`.
- **Polimorfismo:** tratamiento genérico de distintos tipos de widgets.
- **Sobrecarga:** métodos `buscar(int)` y `buscar(String)`.
- **Comparable:** ordenamiento por memoria, con desempate por ID.
- **Encapsulación:** atributos privados y acceso mediante métodos.
- **MVC:** separación del modelo, la vista y el controlador.
- **Sobrescritura:** métodos `renderizar`, `toString`, `equals` y `hashCode`.

## Consideraciones

- El clima utiliza datos simulados.
- Los relojes utilizan la hora real de su zona configurada.
- Los valores de memoria son estimaciones, no mediciones de la JVM.
- Los datos se mantienen únicamente en memoria y se reinician al cerrar.
- La actualización de la tabla borra la selección actual.