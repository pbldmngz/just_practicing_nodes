//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package NextLVL;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class ColaHyper {

    private Nodo inicio;
    
    public static void main(String arg[]) {
        Tarea t1 = new Tarea("a", 3);
        Tarea t2 = new Tarea("b", 2);
        Tarea t3 = new Tarea("c", 1);
        Tarea t4 = new Tarea("d", 1);
        Tarea t5 = new Tarea("e", 2);
        Tarea t6 = new Tarea("f", 3);
        Tarea t7 = new Tarea("g", 2);

        ColaHyper n = new ColaHyper();

        n.agregarOrdenados(t1);
        n.agregarOrdenados(t2);
        n.agregarOrdenados(t3);
        n.agregarOrdenados(t4);
        n.agregarOrdenados(t5);
        n.agregarOrdenados(t6);
        n.agregarOrdenados(t7);

        n.imprimir();

        /*n.Destroy();
        n.Destroy();
        n.Destroy();*/

        n.imprimir();
    }

    public void insertarInicio(Tarea d) {
        Nodo nuevo = new Nodo(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.getSig() != inicio) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            nuevo.setAnt(aux);
            nuevo.setSig(inicio);
            inicio.setAnt(nuevo);
            inicio = nuevo;

        }
    }

    public void insertarFinal(Tarea d) {
        Nodo nuevo = new Nodo(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.getSig() != inicio) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            nuevo.setAnt(aux);
            nuevo.setSig(inicio);
            inicio.setAnt(nuevo);
        }
    }

    public void agregarOrdenados(Tarea d) {
        Nodo nuevo = new Nodo(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while ((aux.getSig() != inicio) && (aux.getDato().getPr() < d.getPr())) {
                aux = aux.getSig();
            }
            if ((aux.getSig() == inicio) && (aux.getDato().getPr() < d.getPr())) {
                aux.setSig(nuevo);
                nuevo.setAnt(aux);
                nuevo.setSig(inicio);
                inicio.setAnt(nuevo);
            } else {
                Nodo ant = aux.getAnt();
                nuevo.setAnt(ant);
                ant.setSig(nuevo);
                nuevo.setSig(aux);
                aux.setAnt(nuevo);
                if ((aux == inicio) && (inicio.getDato().getPr() > d.getPr())) {
                    inicio = nuevo;
                }
            }
        }
    }

    public void imprimir() {
        if (inicio == null) {
            System.out.println("<-->NULL<-->");
        } else {
            Nodo aux = inicio;
            System.out.print("<--> Inicio");
            do {
                System.out.print(" <--> " + aux.getDato());
                aux = aux.getSig();
            } while (aux != inicio);
            System.out.println(" <-->NULL<-->");
        }
    }

    public boolean buscar(Tarea d) {
        Nodo aux = inicio;
        while ((aux.getSig() != inicio) && (!(aux.getDato().equals(d)))) {
            aux = aux.getSig();
        }
        return aux.getDato().equals(d);
    }

    public void eliminaPosicion(int p) {
        if (inicio != null) {
            if (p > 0) {
                int cont = 1;
                Nodo aux = inicio;
                while ((aux.getSig() != inicio) && (cont < p)) {
                    cont++;
                    aux = aux.getSig();
                }
                if (cont == 1) {
                    if (aux.getSig() == inicio) {
                        inicio = null;
                    } else {
                        Nodo ant = aux.getAnt();
                        ant.setSig(aux.getSig());
                        aux = aux.getSig();
                        aux.setAnt(ant);
                        inicio = aux;
                    }
                } else {
                    Nodo ant = aux.getAnt();
                    aux.setAnt(null);
                    ant.setSig(aux.getSig());
                    aux = aux.getSig();
                    aux.setAnt(ant);
                }
            }

            /*public static void eliminaValor(Tarea d){
        if (inicio != null) {
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux.getSig() != inicio) {
                if (aux.getDato().equals(d)) {
                    if (ant == null) {
                        if (aux.getSig() == inicio) {
                            inicio = null;
                        } else {
                            ant = aux.getAnt();
                            ant.setSig(aux.getSig());
                            aux = aux.getSig();
                            aux.setAnt(ant);
                            inicio = aux;
                            ant = null;
                        }
                    } else {
                        aux.setAnt(null);
                        ant.setSig(aux.getSig());
                        aux = aux.getSig();
                        aux.setAnt(ant);
                    }
                } else {
                    ant = aux;
                    aux = aux.getSig();
                }
            }
        } 
    }*/
        }
    }
    
    
}
