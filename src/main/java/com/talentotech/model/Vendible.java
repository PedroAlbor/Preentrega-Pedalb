package com.talentotech.model;

public interface Vendible {

    //Todo atributo en una interfaz es public static final por defecto
    //es decir, constante.
    String ESTADO_DEFAULT = "Disponible";

    //Todo metodo en una interfaz es public
    //abstract por defecto, es decir, metodo abstracto.
    void aplicarDescuento(double porcentaje);

    // Todo metodo default en una interfaz es public por defecto,
    //es decir, metodo concreto. La clase que lo implementa puede
    //sobreescribirlo o no.
    default void mostrarEstado(){
        System.out.println("ESTADO DEL PRODUCTO: "+ESTADO_DEFAULT);
    }

    // Metodo static: pertenece a la interfaz y no a la instancia.
    // Se puede lamar sin crear un objeto de la interfaz.

    static double calcularDescuento(double precio, double porcentaje){
        return precio - (precio*porcentaje/100);
    }

    //No tiene constructor no estado de instancia, ya que no se puede instanciar
    //una interfaz. Solo se puedfe implementar en clases concretas.
    // Una clase puede implementar varias interfaces, pero solo puede extender una
    // clase abstracta. Por eso es util usar interfaces para definir
    // comportamientos que pueden ser compartidos por diferentes clases
    // Implementar varias interfaces separadas por coma (implements A,B)


}