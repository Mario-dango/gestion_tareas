package egg.models;

import java.time.Duration;
import java.time.LocalDateTime;

/*
 * Cada tarea tiene un tiempo de inicio (se registra automáticamente cuando se crea la tarea) 
vencimiento (ingresada por el usuario como LocalDate), finalización, una descripción y un id.
 */

public class Tarea {
    
    //  Atributo de la clase
    private static int contadorTareas = 0;
    //  Atributos de la instancia
    private int idTarea;
    private LocalDateTime tiempoInicio = null;
    private LocalDateTime tiempoFinal = null;
    private LocalDateTime tiempoVencimiento = null;
    private String descripcionTarea;
    
    //  Constructor con id incremental
    public Tarea(LocalDateTime tiempoVencimiento, String descripcionTarea) {
        contadorTareas++;
        this.idTarea = contadorTareas;
        this.tiempoInicio = LocalDateTime.now();
        this.tiempoFinal = null;
        this.tiempoVencimiento = tiempoVencimiento;
        this.descripcionTarea = descripcionTarea;
    }

    //  Constructor con id incremental por parametros
    public Tarea(int idTarea, LocalDateTime tiempoInicio, LocalDateTime tiempoFinal, LocalDateTime tiempoVencimiento,
            String descripcionTarea) {
        this.idTarea = idTarea;
        this.tiempoInicio = tiempoInicio;
        this.tiempoFinal = tiempoFinal;
        this.tiempoVencimiento = tiempoVencimiento;
        this.descripcionTarea = descripcionTarea;
    }

    ///////////////////// Diferencia ////////////////////////
    public Duration getDuracionReal() {
        return (Duration.between(tiempoInicio, tiempoFinal));
    }

    public Duration getDuracionHipotetica() {
        return (Duration.between(tiempoInicio, tiempoVencimiento));
    }

    ///////////////////// SECCIÓN DE GETTERS Y SETTERS ////////////////////////
    public static int getContadorTareas() {
        return contadorTareas;
    }

    public static void setContadorTareas(int contadorTareas) {
        Tarea.contadorTareas = contadorTareas;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public LocalDateTime getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(LocalDateTime tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public LocalDateTime getTiempoFinal() {
        return tiempoFinal;
    }

    public void setTiempoFinal(LocalDateTime tiempoFinal) {
        this.tiempoFinal = tiempoFinal;
    }

    public LocalDateTime getTiempoVencimiento() {
        return tiempoVencimiento;
    }

    public void setTiempoVencimiento(LocalDateTime tiempoVencimiento) {
        this.tiempoVencimiento = tiempoVencimiento;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }
    ///////////////////// SECCIÓN DE HASCODE Y EQUALS ////////////////////////


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idTarea;
        result = prime * result + ((tiempoInicio == null) ? 0 : tiempoInicio.hashCode());
        result = prime * result + ((tiempoFinal == null) ? 0 : tiempoFinal.hashCode());
        result = prime * result + ((tiempoVencimiento == null) ? 0 : tiempoVencimiento.hashCode());
        result = prime * result + ((descripcionTarea == null) ? 0 : descripcionTarea.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarea other = (Tarea) obj;
        if (idTarea != other.idTarea)
            return false;
        if (tiempoInicio == null) {
            if (other.tiempoInicio != null)
                return false;
        } else if (!tiempoInicio.equals(other.tiempoInicio))
            return false;
        if (tiempoFinal == null) {
            if (other.tiempoFinal != null)
                return false;
        } else if (!tiempoFinal.equals(other.tiempoFinal))
            return false;
        if (tiempoVencimiento == null) {
            if (other.tiempoVencimiento != null)
                return false;
        } else if (!tiempoVencimiento.equals(other.tiempoVencimiento))
            return false;
        if (descripcionTarea == null) {
            if (other.descripcionTarea != null)
                return false;
        } else if (!descripcionTarea.equals(other.descripcionTarea))
            return false;
        return true;
    }

       

}
