package egg.interfaces;

/*
 * La interfaz debe tener los siguientes métodos:
 *  void imprimirTitulo(): Debe imprimir el nombre del menú.
 *  void imprimirOpciones(); Imprime las opciones del menú
 *  Integer obtenerOpcion(); Tendrá la lógica para pedir al usuario la opción
 *  void seleccionarOpcion(Integer opcion): Tendrá la lógica para derivar la 
 *          ejecucación de una accion en base a la opcion que recibe por parametro.
 *  Boolean validarSalida(Integer opcion); Tendrá la lógica de validar si la 
 *          opcion es de salida o no para terminar el bucle y salir del menú.
 *  void saludo(); Debe imprimir un saludo luego de cerrar el menú.
 *  default void iniciar(): Será un método por default, es decir, estará 
 *          implementado en la interfaz, que tiene que tener la lógica donde 
 *          se invoque a los métodos anteriores.
 */

public interface MenuServicio {
    
    public void imprimirTitulo();
    public void imprimirOpciones();
    public Integer obtenerOpcion();
    public void seleccionarOpcion(Integer opcion);
    public Boolean validarSalida(Integer opcion);
    public void saludo();

    default public void iniciar(){
        Integer opcion = 0;
        do {            
            imprimirTitulo();
            imprimirOpciones();
            opcion = obtenerOpcion();
            seleccionarOpcion(opcion);
        } while (validarSalida(opcion));
        saludo();
    }

}
