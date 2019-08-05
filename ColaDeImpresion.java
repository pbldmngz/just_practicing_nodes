/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NextLVL;

/**
 *
 * @author MGR#8955
 */
public class ColaDeImpresion {

    private Nodo inicio;
    private Nodo ultimo;

    public void agregar(Tarea t) {

        Nodo nodo = new Nodo(t);

        if (inicio == null) {
            inicio = nodo;
        } else {

            Nodo aux = inicio;

            while (aux != null) {
                Tarea n = aux.getDato();
                Tarea s = nodo.getDato();

                if (aux == inicio && n.getPr() >= s.getPr()) {
                    aux.setAnt(nodo);
                    nodo.setSig(aux);

                    inicio = nodo;
                    break;

                }
                if (n.getPr() >= s.getPr()) {
                    aux.setAnt(nodo);
                    nodo.setSig(aux);

                    break;

                } else {
                    if (n.getPr() <= s.getPr()) {

                        nodo.setAnt(aux);
                        nodo.setSig(aux.getSig());
                        aux.setSig(nodo);
                        break;
                    } else {
                        aux = aux.getSig();
                    }
                }
            }
        }
    }

    public void borrar() {

        Nodo aux = inicio;
        System.out.println(aux.getDato());
        Nodo n = aux.getSig();
        aux = null;
        inicio = n;

    }

    public void imprime() {

        Nodo aux = inicio;

        while (aux != null) {

            System.out.println(aux.getDato());
            aux = aux.getSig();
        }
    }

    public static void main(String arg[]) {
        Tarea tarea1 = new Tarea("b", 2);
        Tarea tarea3 = new Tarea("c", 3);
        Tarea tarea2 = new Tarea("a", 1);
        Tarea tarea4 = new Tarea("d", 1);
        ColaDeImpresion n = new ColaDeImpresion();
        n.agregar(tarea1);
        n.agregar(tarea2);
        n.agregar(tarea3);
        n.agregar(tarea4);
        n.imprime();
        //  n.borrar();
        //  n.imprime();
    }
}
