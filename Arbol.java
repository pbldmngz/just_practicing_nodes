package edu.cetys.edya.ejemplo2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author gvelez, dpablo
 */
public class Arbol {

    public Nodo raiz;

    public Arbol(int valor) {
        this.raiz = new Nodo(valor);
    }

    public void addNodo(int valor) {
        /* 1.- Se toma el dato a ingresar y se crea un nodo */
        this.addNodo(new Nodo(valor));
    }

    private void addNodo(Nodo nodo) {
        this.addNodo(nodo, this.raiz);
    }

    private void addNodo(Nodo nodo, Nodo raiz) {
        /* 2.- Partiendo de la raíz preguntamos: Nodo == null ( o no existe ) ? */
        if (raiz == null) {
            /* 
             * 3.- En caso afirmativo X pasa a ocupar el lugar del nodo y ya 
             * hemos ingresado nuestro primer dato. 
             */
            this.raiz = nodo;
        } else {
            /* 4.- En caso negativo preguntamos: X < Nodo */
            if (nodo.valor <= raiz.valor) {
                /* 
                 * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
                 * que acabamos de preguntar y repetimos desde el paso 2 
                 * partiendo del Nodo al que acabamos de visitar 
                 */
                if (raiz.hijoIzquierdo == null) {
                    raiz.hijoIzquierdo = nodo;
                } else {
                    addNodo(nodo, raiz.hijoIzquierdo);
                }
            } else {
                /* 
                 * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
                 * cual hicimos con el caso anterior repetimos desde el paso 2
                 * partiendo de este nuevo Nodo.
                 */
                if (raiz.hijoDerecho == null) {
                    raiz.hijoDerecho = nodo;
                } else {
                    addNodo(nodo, raiz.hijoDerecho);
                }
            }
        }
    }

    public void recorridoPreOrder() {
        System.out.print("[");
        recorridoPreOrder(this.raiz);
        System.out.println("]");
        //Inicio de recorrido PreOrder desde la raíz
    }

    public void recorridoPreOrder(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.valor + ", ");
        recorridoPreOrder(nodo.hijoIzquierdo);
        recorridoPreOrder(nodo.hijoDerecho);
        //Recorrido a través de los nodos PreOrder
    }

    public void recorridoInOrder() {
        System.out.print("[");
        recorridoInOrder(this.raiz);
        System.out.println("]");
        //Inicio de recorrido InOrder desde la raíz
    }

    public void recorridoInOrder(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        recorridoInOrder(nodo.hijoIzquierdo);
        System.out.print(nodo.valor + ", ");
        recorridoInOrder(nodo.hijoDerecho);
        //Recorrido a través de los nodos InOrder
    }
    
    public void recorridoPosOrder() {
        System.out.print("[");
        recorridoPosOrder(this.raiz);
        System.out.println("]");
        //Inicio de recorrido PosOrder desde la raíz
    }

    public void recorridoPosOrder(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        recorridoPosOrder(nodo.hijoIzquierdo);
        recorridoPosOrder(nodo.hijoDerecho);
        System.out.print(nodo.valor + ", ");
        //Recorrido a través de los nodos PosOrder
    }

    public void print() {
        // Base Case 
        if (this.raiz == null) {
            return;
        }

        // Create an empty queue for level order tarversal 
        Queue<Nodo> q = new LinkedList<Nodo>();

        // Enqueue Root and initialize height 
        q.add(this.raiz);

        while (true) {

            // nodeCount (queue size) indicates number of nodes 
            // at current level. 
            int nodeCount = q.size();
            if (nodeCount == 0) {
                break;
            }

            // Dequeue all nodes of current level and Enqueue all 
            // nodes of next level 
            while (nodeCount > 0) {
                Nodo nodo = q.peek();
                System.out.print(nodo.valor + " ");
                q.remove();
                if (nodo.hijoIzquierdo != null) {
                    q.add(nodo.hijoIzquierdo);
                }
                if (nodo.hijoDerecho != null) {
                    q.add(nodo.hijoDerecho);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }
}
