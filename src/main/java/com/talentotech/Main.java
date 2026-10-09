package com.talentotech;

import java.util.Scanner;

import com.talentotech.exception.ProductoNoEncontradoException;
import com.talentotech.exception.StockInsuficienteException;
import com.talentotech.model.Electronico;
import com.talentotech.model.Producto;
import com.talentotech.model.Ropa;
import com.talentotech.service.ProductoService;
import com.talentotech.ui.MenuProducto;
import com.talentotech.util.Validador;

public class Main {
    public static void main(String[] args) {
        // Creamos las dependencias una sola vez y las compartimos
        // durante toda la ejecución del programa.
        ProductoService service = new ProductoService();
        Scanner sc = new Scanner(System.in);
        MenuProducto menu = new MenuProducto(sc, service);
        cargarDatosDePrueba(service);

        int opcion;

        // do-while garantiza que el menú se muestre al menos una
        // vez. Se repite hasta que el usuario elige la opción 6.
        do {
            menu.mostrarMenu();
            opcion = Validador.leerEntero(sc, "Elija una opción: ");

            // Cada opción del menú está envuelta en try/catch.
            // Si una operación lanza una excepción (producto
            // inexistente, datos inválidos, etc.), el programa NO
            // se cae: muestra el mensaje y vuelve a mostrar el menú.

            try {
                switch (opcion) {
                    case 1 -> menu.agregarProducto();
                    case 2 -> menu.listarProductos();
                    case 3 -> menu.buscarProducto();
                    case 4 -> menu.actualizarProducto();
                    case 5 -> menu.eliminarProducto();
                    case 6 -> System.out.println("chao chao");
                    default -> System.out.println("Opción inválida. Elija un número del 1 al 6.");
                }
            } catch (ProductoNoEncontradoException | StockInsuficienteException e) {
                // capturamos las excepciones personalizadas
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                // Validador de datos genericos invalidos
                // (nombre,precio negativo,etc...)
                System.out.println(e.getMessage());
            }

        } while (opcion != 6);

        sc.close();

    }

    private static void cargarDatosDePrueba(ProductoService service) {
        service.guardar(new Producto("Giorgio Armani Stronger whit you", 4500, 30, "Perfume"));
        service.guardar(new Producto("Natura homen", 3200, 50, "Perfume hombre"));
        service.guardar(new Producto("Jean Paul Gaultier lebelle", 1850, 100, "Perfume mujer"));
        service.guardar(new Producto("Carolina Herrera La bomba", 6700, 20, "Perfume mujer"));
        service.guardar(new Producto("Jean Paul Gaultier Le Beau", 2900, 15, "Perfume hombre"));
        // Polimorfismo: el servicio guarda Producto, y Ropa/Electronico
        // SON productos (heredan de Producto), así que se aceptan igual.
        service.guardar(new Ropa("Remera", 10000, 10, "M"));
        service.guardar(new Electronico("Auriculares bluetooth", 35000, 5, 12));
        System.out.println("✔ Se cargaron 7 productos de prueba.\n");
    }
}
