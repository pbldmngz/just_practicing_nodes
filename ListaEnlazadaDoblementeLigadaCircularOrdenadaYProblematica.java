//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package Libre;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class ListaEnlazadaDoblementeLigadaCircularOrdenadaYProblematica {

    private Nodo inicio;
    private Nodo ultimo;

    public ListaEnlazadaDoblementeLigadaCircularOrdenadaYProblematica() {
        inicio = null;
        ultimo = null;
    }

    public void Add(Tarea task) {
        Nodo nd = new Nodo(task);
        Nodo aux, extra;
        boolean ctrl = false;

        if (inicio == null) {
            nd.setAnt(nd);
            nd.setSig(nd);
            inicio = nd;
            ultimo = inicio;
        } else if (task.getPr() <= inicio.getDato().getPr()) {
            inicio.setAnt(nd);
            nd.setAnt(ultimo);
            ultimo.setSig(nd);
            nd.setSig(inicio);
            inicio = nd;
        } else if (task.getPr() >= ultimo.getDato().getPr()) {
            inicio.setAnt(nd);
            nd.setAnt(ultimo);
            ultimo.setSig(nd);
            nd.setSig(inicio);
            ultimo = nd;
        } else {
            //Y aquí lo que hace que esta cosa funcione
            aux = inicio;
            extra = inicio.getSig();
            while (extra != null) {
                if (task.getPr() >= aux.getDato().getPr() && task.getPr() <= extra.getDato().getPr()) {
                    nd.setSig(extra);
                    aux.setSig(nd);
                    nd.setAnt(aux);
                    extra.setAnt(nd);
                    ctrl = true;
                    break;
                } else {
                    aux = extra;
                    extra = extra.getSig();
                }
            }
            if (ctrl == false) {
                nd.setAnt(aux);
                aux.setSig(nd);
            }
        }
    }

    public void Destroy() {
        inicio.getSig().setAnt(inicio.getAnt());
        inicio.getAnt().setSig(inicio.getSig());
        inicio = inicio.getSig();
    }

    public void Print() {
        Nodo aux = inicio;
        int c = 0;
        do {
            System.out.println(c + ". " + aux.getDato());
            c++;
            aux = aux.getSig();
        } while (aux != inicio);
        System.out.println("");
    }

    public void ReversePrint() {
        Nodo aux = ultimo;
        int c = 0;
        do {
            System.out.println(c + ". " + aux.getDato());
            c++;
            aux = aux.getAnt();
        } while (aux != ultimo);
        System.out.println("");
    }

    public static void main(String arg[]) {
        Tarea t1 = new Tarea("a", 3);
        Tarea t2 = new Tarea("b", 2);
        Tarea t3 = new Tarea("c", 1);
        Tarea t4 = new Tarea("d", 1);
        Tarea t5 = new Tarea("e", 2);
        Tarea t6 = new Tarea("f", 3);
        Tarea t7 = new Tarea("g", 2);

        ListaEnlazadaDoblementeLigadaCircularOrdenadaYProblematica n = new ListaEnlazadaDoblementeLigadaCircularOrdenadaYProblematica();

        n.Add(t1);
        n.Add(t2);
        n.Add(t3);
        n.Add(t4);
        n.Add(t5);
        n.Add(t6);
        n.Add(t7);

        n.Print();

        n.Destroy();
        n.Destroy();
        n.Destroy();

        n.Print();

        n.ReversePrint();
    }
}
