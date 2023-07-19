package egg.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import egg.models.Tarea;

public class TareaServicio {

    private List<Tarea> listaDeTareas = new ArrayList<Tarea>();

    private TareaServicio(){
        
    }

    private static TareaServicio instance;
    public static TareaServicio getInstance() {
        if (instance == null) {
            instance = new TareaServicio();
        }
        return instance;
    }

    public void crearTarea(LocalDateTime vencimiento, String descripcion){
        Tarea nuevaTarea = new Tarea(vencimiento, descripcion);
        listaDeTareas.add(nuevaTarea);
    }

    public boolean finalizarTarea(int identificadorDeTarea){
        Tarea tareaParaFinalizar = buscarTarea(identificadorDeTarea);
        if (tareaParaFinalizar != null){
            tareaParaFinalizar.setTiempoFinal(LocalDateTime.now());
            return true;
        }
        return false;   //  No se encontró la tarea
    }

    public List<Tarea> verTareas(){

        return null;
    }

    public boolean eliminarTarea(int id) { 
        Tarea tareaParaEliminar = buscarTarea(id);
        if (tareaParaEliminar != null){
            listaDeTareas.remove(tareaParaEliminar);
            return true;
        }
        return false;   //  No se encontró la tarea
    }

    public boolean editarTarea(String nuevaDescripcion, int id) {
        Tarea tareaParaEditar = buscarTarea(id);
        if (tareaParaEditar != null){
            tareaParaEditar.setDescripcionTarea(nuevaDescripcion);
            return true;
        }
        return false;
    }

    public String tiempoTotalDeTrabajo() {
        Duration tiempoDiferencia = Duration.between(LocalTime.of(0, 0, 0),LocalTime.of(0, 0, 0));;
        for (Tarea tarea : listaDeTareas) {
            if (tarea.getTiempoFinal() != null){
                tiempoDiferencia.plus(tarea.getDuracionReal());
            } 
        }
        String tiempoTotal = (
            tiempoDiferencia.toDaysPart() + "/" + 
            tiempoDiferencia.toHoursPart() + ":" + 
            tiempoDiferencia.toMinutesPart() + ":" + 
            tiempoDiferencia.toSecondsPart()
        );          
        return tiempoTotal;
    }

    public Tarea buscarTarea(int index) {        
        for (Tarea tarea : listaDeTareas) {
            if (tarea.getIdTarea() == index){
                return tarea;
            }
        }
        return null;
    }
    
    public Tarea buscarTarea(String descripString) {        
        for (Tarea tarea : listaDeTareas) {
            if (tarea.getDescripcionTarea().equals(descripString)){
                return tarea;
            }
        }
        return null;
    }

    public List<Tarea> ordenarTarea(int tipoDeOrden) {
        switch (tipoDeOrden) {
            case 1:             //  Ordenar por ID
                listaDeTareas.sort(Comparator.comparing(t -> t.getIdTarea()));
                break;
            case 2:             //  Ordenar por descripción
                listaDeTareas.sort(Comparator.comparing(t -> t.getDescripcionTarea().toLowerCase()));
                break;
            case 3:             //  Ordenar por fecha de inicio
                listaDeTareas.sort(Comparator.comparing(t -> t.getTiempoInicio()));
                break;
            case 4:             //  Ordenar por fecha de finalizacion
                listaDeTareas.sort(Comparator.comparing(t -> t.getTiempoFinal()));
                break;
            case 5:             //  Ordenar por fecha de vencimiento
                listaDeTareas.sort(Comparator.comparing(t -> t.getTiempoVencimiento()));
                break;        
            default:
                return null;
        }
        return listaDeTareas;
    }
    
}


/*
Ejercicio Tareas
Aplicación de Seguimiento de Tiempo: Desarrolla una aplicación que permita a los usuarios registrar y 
gestionar sus tareas. Cada tarea tiene un tiempo de inicio (se registra automáticamente cuando se crea la tarea) 
vencimiento (ingresada por el usuario como LocalDate), finalización, una descripción y un id.

*** Crear tareas: Al crear una tarea, los usuarios deben ingresar una descripción de la tarea e ingresar 
su fecha de vencimiento. La aplicación deberá registrar la fecha y hora actuales como tiempo de inicio 
de la tarea utilizando LocalDateTime. El id lo puedes obtener creando un atributo static que funcione 
como contador y cada vez que se crea una instancia de una tarea aumente en 1 y le asigne el valor a el 
atributo id de la instancia.

*** Finalizar tareas: Los usuarios deben tener la opción de marcar una tarea como finalizada. Al hacerlo, 
la aplicación debe registrar la fecha y hora actuales como tiempo de finalización de la tarea. 

Ver tareas: Los usuarios deben poder ver una lista de todas las tareas, tanto completadas como pendientes. 
Para cada tarea completada, la aplicación debe mostrar la descripción, la fecha de inicio y fin, y la 
duración de la tarea . Para las tareas pendientes, la aplicación debe mostrar la descripción y la fecha de 
inicio, y cuántos días quedan para el vencimiento.

** Eliminar tareas: Los usuarios deben poder eliminar una tarea ingresando su id

** Editar tareas: Los usuarios deben poder editar la descripción de una tarea.

Tiempo total de trabajo: La aplicación debe proporcionar un resumen que muestre el tiempo total de trabajo, 
sumando las duraciones de todas las tareas completadas.

*** Buscar tareas: Los usuarios deben poder buscar tareas por descripción. La aplicación debe mostrar todas las 
tareas que coincidan con la descripción ingresada.

*** Ordenar tareas: Los usuarios deben poder ordenar tareas alfabéticamente, por fecha de inicio, por id, por fecha 
de vencimiento, y por fecha de finalización (ten cuidado con la fecha de finalización que puede ser nula para 
tareas que no han finalizado).

 */
