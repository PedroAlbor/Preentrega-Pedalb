package com.talentotech.demo;

import com.talentotech.model.Electronico;
import com.talentotech.model.Producto;
import com.talentotech.model.Ropa;
import com.talentotech.model.Vendible;

import java.util.ArrayList;
import java.util.List;

/*
    Ejemplos de la clase de herencia, casteo, interfaces y ArrayList.
    No forma parte del ecommerce: es un main aparte para practicar.
    El programa principal está en com.talentotech.Main.
*/
public class DemoHerencia {
    public static void main(String[] args) {

        Producto producto1 = new Ropa("Remera", 1000.7, 10, "M");

        producto1.mostrarDatos();
        System.out.println("Categoria: " + producto1.getCategoria());

        Producto producto2 = new Ropa("Pantalon", 2000.0, 5, "L");
        producto2.mostrarDatos();
        System.out.println("Categoria: " + producto2.getCategoria());

        Ropa producto3 = new Ropa("Camisa", 1500.0, 8, "S");

        System.out.println("--------------------------------");
        System.out.println("Total de productos: " + Producto.getTotalProductos());

        double precioDescuento = Vendible.calcularDescuento(producto1.getPrecio(), 10.0);
        System.out.println("Precio con descuento: " + precioDescuento);

        // CASTEO es decirle a Java "trata este dato como si fuera de otro tipo"
        double precioProducto1 = producto1.getPrecio();
        int precio = (int) precioProducto1;
        System.out.println("Precio producto 1 : " + precio);

        // EXPLICACION DE INTERFACES
        // como producto1 y producto2 son de tipo Poducto, no podemos llamar a los
        // metodos de las interfaces Vendible y Etiquetable directamente. Para poder
        // acceder a esos metodos, necesitamos hacer un cast a la clase Ropa, que es la
        // que implementa esas interfaces.
        System.out.println("--------------------------------");
        Ropa ropa1 = (Ropa) producto1;
        ropa1.aplicarDescuento(10.0);
        ropa1.generarEtiqueta();
        Ropa ropa2 = (Ropa) producto2;
        ropa2.aplicarDescuento(15.0);
        ropa2.generarEtiqueta();

        System.out.println("--------------------------------");
        producto3.mostrarDatos();
        producto3.aplicarDescuento(20.0);
        producto3.generarEtiqueta();

        System.out.println("--------------------------------");

        // ArrayList : lista dinámica que puede crecer o achicarse en tiempo de
        // ejecución (a diferencia de los arrays comunes, que tienen tamaño fijo)

        // metodos más comunes de ArrayList: add(), remove(), get(), size(), clear(), isEmpty()
        List<Producto> productos = new ArrayList<>();

        //agregar
        productos.add(producto1);
        productos.add(producto2);
        productos.add(new Ropa("Remera", 1000.0, 10, "M"));
        productos.add(new Electronico("Notebook", 850000.0, 3, 12));

        // obtener
        Producto p = productos.get(2);
        System.out.println("Producto en la posicion 3: " + p.getNombre());

    }
}
