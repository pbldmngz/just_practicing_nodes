//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package NextLVL;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Cola2 {
    
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
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            inicio.setAnt(nuevo);
            nuevo.setSig(inicio);
            ultimo = nuevo;
        }
    }
    
    public void Destroy() {
        System.out.println("Fallo por aqui");
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
        
        Cola2 n = new Cola2();
        
        n.Add(t1);
        n.Add(t2);
        n.Add(t3);
        n.Add(t4);
        n.Add(t5);
        n.Add(t6);
        n.Add(t7);
        
        n.Print();

        /*n.Destroy();
        n.Destroy();
        n.Destroy();*/
        n.ReversePrint();
    }
}
