package egg;

import egg.services.MenuGeneralServicioImpl;

public class Application {

    public static void main(String[] args) {
        MenuGeneralServicioImpl menuDeLaAplicacion = new MenuGeneralServicioImpl();
        menuDeLaAplicacion.iniciar();
    }
}

/*
Ejercicio Tareas
Aplicación de Seguimiento de Tiempo: Desarrolla una aplicación que permita a los usuarios registrar y 
gestionar sus tareas. Cada tarea tiene un tiempo de inicio (se registra automáticamente cuando se crea la tarea) 
vencimiento (ingresada por el usuario como LocalDate), finalización, una descripción y un id.

Crear tareas: Al crear una tarea, los usuarios deben ingresar una descripción de la tarea e ingresar 
su fecha de vencimiento. La aplicación deberá registrar la fecha y hora actuales como tiempo de inicio 
de la tarea utilizando LocalDateTime. El id lo puedes obtener creando un atributo static que funcione 
como contador y cada vez que se crea una instancia de una tarea aumente en 1 y le asigne el valor a el 
atributo id de la instancia.

Finalizar tareas: Los usuarios deben tener la opción de marcar una tarea como finalizada. Al hacerlo, 
la aplicación debe registrar la fecha y hora actuales como tiempo de finalización de la tarea. 

Ver tareas: Los usuarios deben poder ver una lista de todas las tareas, tanto completadas como pendientes. 
Para cada tarea completada, la aplicación debe mostrar la descripción, la fecha de inicio y fin, y la 
duración de la tarea . Para las tareas pendientes, la aplicación debe mostrar la descripción y la fecha de 
inicio, y cuántos días quedan para el vencimiento.

Eliminar tareas: Los usuarios deben poder eliminar una tarea ingresando su id

Editar tareas: Los usuarios deben poder editar la descripción de una tarea.

Tiempo total de trabajo: La aplicación debe proporcionar un resumen que muestre el tiempo total de trabajo, 
sumando las duraciones de todas las tareas completadas.

Buscar tareas: Los usuarios deben poder buscar tareas por descripción. La aplicación debe mostrar todas las 
tareas que coincidan con la descripción ingresada.

Ordenar tareas: Los usuarios deben poder ordenar tareas alfabéticamente, por fecha de inicio, por id, por fecha 
de vencimiento, y por fecha de finalización (ten cuidado con la fecha de finalización que puede ser nula para 
tareas que no han finalizado).

 */
