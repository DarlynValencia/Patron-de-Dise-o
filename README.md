Explicación del problema

El sistema debe permitir al departamento de Bienestar Universitario registrar las horas de participación de los estudiantes en diferentes actividades (como deporte, cultura o voluntariado).
Cada estudiante necesita cumplir un número mínimo de horas para poder graduarse.
El problema original era que los registros se hacían manualmente y no había forma de verificar cuántas horas llevaba acumuladas cada estudiante.

Solucion del problema

1. El sistema propone un modelo orientado a objetos que permite:
Registrar estudiantes.
Asignar servicios a cada estudiante.
Extender o modificar los servicios fácilmente (gracias a patrones de diseño).
Notificar o actualizar información mediante observadores.
Todo esto se logra combinando clases e interfaces con patrones de diseño.

2. Lógica del sistema
La interfaz Servicio define el contrato de lo que significa prestar un servicio (prestado()).
ServicioBase implementa la versión general del servicio.
Clases concretas (Cultural, Deportivo, Tutorias) heredan de ServicioBase para ofrecer servicios específicos.
ServicioDecorador permite añadir comportamientos extra (por ejemplo, registrar, notificar o auditar) sin cambiar la clase base.
Estudiante representa a cada usuario del sistema, con nombre y código.
RegistroAcademico permite almacenar o asociar información del estudiante.
Observador y Notificador representan el patrón Observer, para enviar actualizaciones automáticas.
BienestarUniversitario actúa como controlador central:
Registra estudiantes.
Asigna servicios.
Llama a los métodos de los servicios (prestado()).

3. Patrones de diseño utilizados
Patrón	Dónde aparece	Propósito
Factory / Abstract Factory	En la creación de servicios (Cultural, Deportivo, Tutorias)	Facilita crear servicios sin acoplarse a las clases concretas.
Decorator	Clase ServicioDecorador	Permite añadir funcionalidades adicionales a los servicios sin modificar sus clases originales.
Observer	Observador y Notificador	Permite que el sistema notifique a los estudiantes o registros cuando ocurre un cambio (por ejemplo, un nuevo servicio).
4. Ejemplo práctico de uso
El estudiante Juan se registra en el sistema.
El administrador de Bienestar asigna el servicio Cultural.
El sistema ejecuta servicio.prestado() → imprime o registra “Servicio cultural prestado al estudiante Juan”.
El notificador (observador) envía una alerta o mensaje.
El RegistroAcadémico guarda la relación entre el estudiante y el servicio.

5. Conclusión
El proyecto BienestarU resuelve la problemática de la falta de automatización y estructura en la gestión de servicios de bienestar universitario, aplicando principios de programación orientada a objetos y patrones de diseño (Decorator, Observer, Factory) para crear un sistema flexible, extensible y reutilizable.
