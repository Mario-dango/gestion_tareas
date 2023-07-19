package egg.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import egg.interfaces.MenuServicio;

public class MenuGeneralServicioImpl implements MenuServicio{
    
    private Scanner myScannerMenuGeneral = new Scanner(System.in);
    public TareaServicio tareaServicio = TareaServicio.getInstance();
    private List<String> listaOpciones = null;
    private Integer cantidadDeOpciones;

    @Override
    public void imprimirOpciones() {
        this.cantidadDeOpciones = 8;
        System.out.println("[1] Crear Tarea");
        System.out.println("[2] Finalizar Tarea");
        System.out.println("[3] ");
        System.out.println("[4] ");
        System.out.println("[5] ");
        System.out.println("[6] ");
        System.out.println("[7] ");
        System.out.println("[8] ");
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
        System.out.println("Ingrese fecha de vencimiento de la forma yyyy-MM-ddTHH:mm:ss");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:ss");
        String vencimientoString = myScannerMenuGeneral.nextLine();
        LocalDateTime fechaVencimiento = LocalDateTime.parse(vencimientoString, formato);

        System.out.println("Ingrese la descripción de la tarea: ");
        String descripcionString = myScannerMenuGeneral.nextLine();
        tareaServicio.crearTarea(fechaVencimiento, descripcionString);
    }

    //  Finalizar Tarea
    private void opcion2(){
        System.out.println("Se seleccionó la opción 2");
        LocalDateTime 
    }

}
