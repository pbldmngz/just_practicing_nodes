//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package NextLVL;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Cola4 {

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

            while (aux != null) {
                System.out.println("Spicy shit");
                if (aux == inicio && aux.getDato().getPr() >= nuevo.getDato().getPr()) {
                    System.out.println(aux.getDato().getPr() + " > " + nuevo.getDato().getPr());
                    inicio = nuevo;
                    nuevo.setSig(aux);
                    aux.setAnt(nuevo);

                    ultimo.setSig(nuevo);
                    nuevo.setAnt(ultimo);
                    inicio.setAnt(nuevo);
                    nuevo.setSig(inicio);
                    ultimo = nuevo;
                    break;
                } else if (aux == inicio && aux.getDato().getPr() <= nuevo.getDato().getPr()) {
                    System.out.println(aux.getDato().getPr() + " < " + nuevo.getDato().getPr());
                    inicio = aux;
                    aux.setSig(nuevo);
                    nuevo.setAnt(aux);
                    break;
                } else if (aux.getDato().getPr() >= nuevo.getDato().getPr()) {
                    System.out.println(aux.getDato().getPr() + " >2 " + nuevo.getDato().getPr());
                    aux.setAnt(nuevo);
                    nuevo.setSig(aux);
                    break;
                } else if (aux.getDato().getPr() <= nuevo.getDato().getPr()) {
                    System.out.println(aux.getDato().getPr() + " <2 " + nuevo.getDato().getPr());
                    nuevo.setAnt(aux);
                    aux.setSig(nuevo);
                    break;
                } else {
                    System.out.println("&& Else &&");
                }
                aux = aux.getSig();
            }

            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            inicio.setAnt(nuevo);
            nuevo.setSig(inicio);
            ultimo = nuevo;
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

        Cola4 n = new Cola4();

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
