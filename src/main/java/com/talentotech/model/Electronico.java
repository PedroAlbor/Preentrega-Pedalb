package com.talentotech.model;

public class Electronico extends Producto {
    private int mesesGarantia;

    public Electronico(String nombre, double precio, int stock, int mesesGarantia) {
        super(nombre, precio, stock, "Electrónico");
        this.mesesGarantia = mesesGarantia;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    @Override
    public String toString() {
        return super.toString() + " | Garantía: " + mesesGarantia + " meses";
    }
}
