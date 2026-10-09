package com.talentotech.model;

public class Ropa extends Producto implements Vendible, Etiquetable {

    private String talle;

    public Ropa(String nombre, double precio, int stock, String talle) {
        // super() llama al constructor de Producto. La categoría es
        // siempre "Ropa", así que no hace falta pedirla.
        super(nombre, precio, stock, "Ropa");
        this.talle = talle;
    }

    public String getTalle() {
        return talle;
    }

    // Implementación del método abstracto de la interfaz Vendible
    @Override
    public void aplicarDescuento(double porcentaje) {
        setPrecio(Vendible.calcularDescuento(getPrecio(), porcentaje));
        System.out.println("Aplicando " + porcentaje + "% de descuento a " + getNombre()
                + ". Nuevo precio: $" + getPrecio());
    }

    // Implementación del método abstracto de la interfaz Etiquetable
    @Override
    public void generarEtiqueta() {
        System.out.println("Etiqueta: " + getNombre() + " - Talle " + talle);
    }

    @Override
    public String toString() {
        return super.toString() + " | Talle: " + talle;
    }
}
