package supermercado;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long tiempoInicioGeneral = System.currentTimeMillis();

        ClienteProducto cliente1 = new ClienteProducto("Cliente 1", Arrays.asList(
                new Producto("Arroz", 4500, 2),
                new Producto("Leche", 3800, 1),
                new Producto("Huevos", 15000, 3)
        ));

        ClienteProducto cliente2 = new ClienteProducto("Cliente 2", Arrays.asList(
                new Producto("Pan", 3000, 1),
                new Producto("Queso", 12000, 2),
                new Producto("Café", 18000, 2)
        ));

        Cajera cajera1 = new Cajera("Cajera 1", cliente1);
        Cajera cajera2 = new Cajera("Cajera 2", cliente2);

        Thread hilo1 = new Thread(cajera1);
        Thread hilo2 = new Thread(cajera2);

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error: la simulación fue interrumpida.");
        }

        long tiempoFinGeneral = System.currentTimeMillis();
        long tiempoTotalGeneral = tiempoFinGeneral - tiempoInicioGeneral;

        System.out.println("\n=================================");
        System.out.println("Tiempo total de todas las compras: " + tiempoTotalGeneral / 1000.0 + " segundos");
        System.out.println("=================================");
    }
}