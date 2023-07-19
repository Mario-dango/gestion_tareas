package egg.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import egg.interfaces.MenuServicio;
import egg.models.Tarea;

public class MenuGeneralServicioImpl implements MenuServicio{
    
    private Scanner myScannerMenuGeneral = new Scanner(System.in);
    public TareaServicio tareaServicio = TareaServicio.getInstance();
    private List<String> listaOpciones = new LinkedList<String>();
    private Integer cantidadDeOpciones;
    
    @Override
    public void imprimirOpciones() {
        this.cantidadDeOpciones = 8;
        System.out.println("[1] Crear Tarea");
        System.out.println("[2] Finalizar Tarea");
        System.out.println("[3] Ver Tareas");
        System.out.println("[4] Eliminar Tarea");
        System.out.println("[5] Editar Tarea");
        System.out.println("[6] Tiempo Total de Trabajo");
        System.out.println("[7] Buscar Tarea");
        System.out.println("[8] Ordenar Tareas");
        System.out.println("[0] Salir del menu.");
        System.out.println();
    }

    @Override
    public void imprimirTitulo() {
        System.out.println();
        System.out.println("((((SISTEMA GESTION DE TAREAS))))");
    }

    @Override
    public Integer obtenerOpcion() {
        Integer seleccion = 0;
        Boolean seguirIntentando = false;
        System.out.print("\tIngrese la opción númerica del menú: ");
        do {            
            try {
                seleccion = myScannerMenuGeneral.nextInt();
                if (seleccion > this.cantidadDeOpciones || seleccion < 0){
                    seguirIntentando = true;
                    System.out.println("La opción debe de estar dentro del rango.");
                } else {
                    seguirIntentando = false;
                }            
            } catch (Exception e) {
                System.out.println("Por favor, ingresar valor valido.");
                System.out.println("Excepción lanzada: " + e.getMessage());
                e.printStackTrace();
                // myScannerMenuGeneral.next();
                seguirIntentando = true;
            }
        } while (seguirIntentando);
        return seleccion;
    }

    @Override
    public void saludo() {
        System.out.println();
        System.out.println("Gracias por usar el Menu General!");
        System.out.println();        
    }

    @Override
    public void seleccionarOpcion(Integer opcion) {
        try {
            switch (opcion) {
                case 1 -> opcion1();
                case 2 -> opcion2();
                case 3 -> opcion3();
                case 4 -> opcion4();
                case 5 -> opcion5();
                case 6 -> opcion6();
                case 7 -> opcion7();
                case 8 -> opcion8();
                case 0 -> System.out.println("Se seleccionó la opción 0");
            }
        } catch (Exception e) {            
            System.out.println("Se largó excepción: " + e.getMessage());
        }
    }

    @Override
    public Boolean validarSalida(Integer opcion) {
        if (opcion == 0){
            return false;
        } else {
            return true;
        }
    }

    //  Crear tarea
    private void opcion1(){        
        System.out.println("Se seleccionó la opción 1");

        System.out.println("Ingrese fecha de vencimiento de la forma dd-MM-yy_HH:mm:ss");
        myScannerMenuGeneral.nextLine();
        String vencimientoString = myScannerMenuGeneral.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy_HH:mm:ss");
        LocalDateTime fechaVencimiento = LocalDateTime.parse(vencimientoString, formatter);

        System.out.println("Ingrese la descripción de la tarea: ");
        String descripcionString = myScannerMenuGeneral.nextLine();
        
        tareaServicio.crearTarea(fechaVencimiento, descripcionString);
    }

    //  Finalizar Tarea
    private void opcion2(){
        System.out.println("Se seleccionó la opción 2");
        for (Tarea tarea : tareaServicio.getListaDeTareas()) {
            listaOpciones.add(Integer.toString(tarea.getIdTarea()));
        }
        formatearOpciones(listaOpciones);
        listaOpciones.removeAll(listaOpciones);
        
        try {
            int opcionSeleccionada = myScannerMenuGeneral.nextInt();
            if (opcionSeleccionada < 0 ){
                throw new Exception("No hay nada en la Lista de Tareas!");
            } else {
                if (tareaServicio.finalizarTarea(opcionSeleccionada)){
                    System.out.println("Se registro la finalización de la tarea\n\t-> " + opcionSeleccionada);
                } else {
                    System.out.println("Hubo un problema al finalizar la Tarea\n\t-> " + opcionSeleccionada);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Iterator<String> it = listaOpciones.iterator();
        // while(it.hasNext())
        //     System.out.println(it.next());
    }
    
    //  Ver Tareas
    private void opcion3() {
        System.out.println("Se seleccionó la opción 3");
        for (Tarea tareaImpresa : tareaServicio.getListaDeTareas()) {
            imprimirTarea(tareaImpresa);
        }
    }
    
    private void opcion4() {
        System.out.println("Se seleccionó la opción 4");
        listaOpciones.removeAll(listaOpciones);    
        for (Tarea tarea : tareaServicio.getListaDeTareas()) {
            listaOpciones.add(Integer.toString(tarea.getIdTarea()));
        }
        formatearOpciones(listaOpciones);
        listaOpciones.removeAll(listaOpciones);        
    }
    
    private void opcion5() {
        
    }
    
    private void opcion6() {
        
    }
    
    private void opcion7() {
        
    }
    
    private void opcion8() {
        
    }

    private void formatearOpciones(List<String> opcioneStrings){
        System.out.println("Seleccione la Tarea correspondiente");
        for (int i = 0; i < opcioneStrings.size(); i++) {
            System.out.print("[" + (i+1) + "] ");
            System.out.println("Tarea con ID: " + opcioneStrings.get(i));
        }
    }

    private void imprimirTarea(Tarea tareaParaImprimir){
        System.out.println("-----------------------------");
        System.out.println("Tarea ID: " + tareaParaImprimir.getIdTarea());
        System.out.println("\tDescripción: " + tareaParaImprimir.getDescripcionTarea());
        System.out.println("\tFecha de inicio: " + tareaParaImprimir.getTiempoInicio().toString());
        System.out.println("\tFecha de vencimiento: " + tareaParaImprimir.getTiempoVencimiento().toString());
        String casoFinal = null;
        if (tareaParaImprimir.getTiempoFinal() == null){
            casoFinal = "No ha Finalizado aún.";
        } else {
            casoFinal = tareaParaImprimir.getTiempoFinal().toString();
        }
        System.out.println("\tFecha de finalización: " + casoFinal);
    }
}
