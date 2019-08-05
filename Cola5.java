//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package NextLVL;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Cola5 {

    private Nodo inicio;
    private Nodo ultimo;

    public void Cola2() {
        inicio = null;
        ultimo = null;
    }

    public void Add(Tarea task) {
        Nodo nuevo = new Nodo(task);
        if (inicio == null) {
            inicio = nuevo;
            inicio.setSig(inicio);
            inicio.setAnt(ultimo);
            //ultimo.setAnt(inicio);
            ultimo = nuevo;
        } else {
            Nodo aux = inicio;
            Nodo aux2 = ultimo;

            while ((aux.getSig() != inicio) && (aux.getDato().getPr() < task.getPr())) {
                aux = aux.getSig();
            }
            if ((aux.getSig() == inicio) && (aux.getDato().getPr() < task.getPr())) {
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
                if ((aux == inicio) && (inicio.getDato().getPr() > task.getPr())) {
                    inicio = nuevo;
                }
            }
        }

        /*ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            inicio.setAnt(nuevo);
            nuevo.setSig(inicio);
            ultimo = nuevo;*/
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

        Cola5 n = new Cola5();

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
