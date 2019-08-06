package edu.cetys.edya.ejemplo2;

/**
 *
 * @author gvelez, dpablo
 */
public class Cliente {
    
    public static void main(String[] args) {
        
        //Crear raiz /inicio de Arbol
        Arbol arbol = new Arbol(8);
        
        //Insertar hojas
        arbol.addNodo(3);
        arbol.addNodo(10);
        arbol.addNodo(1);
        arbol.addNodo(6);
        arbol.addNodo(14);
        arbol.addNodo(4);
        arbol.addNodo(7);
        arbol.addNodo(13);
        
        //Mostrar Orders
        System.out.println("\nPreorder:");
        arbol.recorridoPreOrder();
        System.out.println("\nIneOrder:");
        arbol.recorridoInOrder();
        System.out.println("\nPosOrder:");
        arbol.recorridoPosOrder();
    }
}
