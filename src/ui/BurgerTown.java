package ui;

import java.util.Scanner;

public class BurgerTown {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a BurgerTown!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada plato vendido en el dia");
            System.out.println("2. Calcular la cantidad total de platos vendidos en el dia");
            System.out.println("3. Calcular el precio promedio de los platos vendidos en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de platos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de platos vendidos en el dia fue de: "+calcularTotalPlatosVendidos());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de los platos vendidos en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarPlatosSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de platos diferentes 
     * vendidos en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de platos diferentes vendidos en el dia ");
        int platos = reader.nextInt();

        precios = new double[platos];
        unidades = new int[platos];

    }
/**
     * Descripcion: Este metodo se encarga de solicitar los precios y la cantidad de cada plat, guardando esta informacion
     * en  arreglos, recorriendo el arreglo con la longitud ya dada por el usuario
     * pre: El scanner  esta inicializado
     * pre: Los arreglos precios y unidades estan inicializados
     * pos: Los datos quedan ingresados en los arreglos
     * 
     */
    public static void solicitarDatos(){


        
        for (int i = 0; i < precios.length; i++) {


        System.out.println("Digite el precio del plato "+(i+1));
        
            precios[i] = reader.nextDouble();
        

        System.out.println("Digite la cantidad de platos "+(i+1));
        
            unidades[i] = reader.nextInt();
        
        }



        
    }
    /**
     * Descripcion: Este metodo se encarga de calcular el total de platos vendidos durante el dia,
     * recorriendo el arreglo de unidades y sumando los valores  
     * pre: Los arreglos precios y unidades estan inicializados
     * pos: Los datos quedan ingresados en los arreglos 
     * @return int vendidos se devuelve la suma de los platos como entero
     */

    public static int calcularTotalPlatosVendidos(){
        
        int vendidos = 0;

        for (int i = 0; i < unidades.length; i++){
            vendidos += unidades[i];
        }

        return vendidos;
        

    }
    /**
     * Descripcion: El metodo debe calcula el precio promedio de los platos vendidos en el dia, recorriendo el arreglo precios y
     * sumando los valores, para luego dividirlo por la cantidad de espacios
     * pre: El arreglo precios esta inicializado
     * pre: el arreglo no puede estar vacio
     * @return double promedio se devuelve el calculo del del precio promedio como double
     */

    public static double calcularPrecioPromedio(){

        double sum_precios=0;
        double promedio=0;

        for (int i=0; i<precios.length; i++){
            sum_precios += precios[i];

        }
            promedio=sum_precios/precios.length;

        return promedio ;
       

    }

    public static double calcularVentasTotales(){

        double ventas_totales = 0;

        for (int i = 0; i < unidades.length; i++){

            ventas_totales += unidades[i]*precios[i];

        }


        return ventas_totales;

    }

    public static int consultarPlatosSobreLimite(double limite){
        int min_ventas=0;
        for(int i = 0; i< unidades.length; i++){
            if ((unidades[i]*precios[i])>limite)
            min_ventas++;
        }

        return min_ventas;

    }

}