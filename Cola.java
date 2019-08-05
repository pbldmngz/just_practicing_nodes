//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package NextLVL;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Cola {

    private Nodo inicio;
    //private Nodos ultimo;

    public void Add(Tarea task) {

        Nodo nd = new Nodo(task);
        if (inicio == null) {
            inicio = nd;
        } else {
            Nodo aux = inicio;
            //Nodos aux2 = ultimo;
            //EL PROBLEMA NO ESTÁ EN LOS IF SINO EN LOS CAMBIOS QUE SE HACEN DENTRO
            while (aux != null) {//Falta testear mucho más, utilizar comentarios de consola en los ifs con los valores de alpha y beta Pr();
                System.out.println("Spicy shit");
                if (aux == inicio && aux.getDato().getPr() >= nd.getDato().getPr()) {
                    System.out.println(aux.getDato().getPr() + " > " + nd.getDato().getPr());
                    inicio = nd;//El aux es el que ya está y ND es el nuevo
                    //ultimo = aux2;
                    nd.setSig(aux);
                    //nd.setAnt(aux2);
                    //aux2.setSig(nd);
                    aux.setAnt(nd);
                    //System.out.println(inicio + " " + inicio.getSig() + " " + inicio.getAnt());
                    break;
                } else if (aux == inicio && aux.getDato().getPr() <= nd.getDato().getPr()) {
                    System.out.println(aux.getDato().getPr() + " < " + nd.getDato().getPr());
                    inicio = aux;//El aux es el que ya está y ND es el nuevo
                    //ultimo = aux2;
                    aux.setSig(nd);
                    //nd.setAnt(aux2);
                    //aux2.setSig(nd);
                    nd.setAnt(aux);
                    break;
                } 
                //NUNCA SE LLEGA A LOS IF DE AQUI ABAJO
                else if (aux.getDato().getPr() >= nd.getDato().getPr()) {
                    System.out.println(aux.getDato().getPr() + " >2 " + nd.getDato().getPr());
                    aux.setAnt(nd);
                    nd.setSig(aux);
                    break;
                } else if (aux.getDato().getPr() <= nd.getDato().getPr()) {
                    System.out.println(aux.getDato().getPr() + " <2 " + nd.getDato().getPr());
                    nd.setAnt(aux);
                    //nd.setSig(aux.getSig());
                    aux.setSig(nd);
                    break;
                } else {
                    System.out.println("&& Else &&");
                    //aux = aux.getSig();
                }
                aux = aux.getSig();
            }
        }
    }

    public void Destroy() {
        System.out.println("Fallo por aqui");
        inicio = inicio.getSig();
    }

    public void Print() {
        Nodo aux = inicio;
        int c = 0;
        while (aux != null) {
            System.out.println(c + ". " + aux.getDato());
            c++;
            aux = aux.getSig();
        }
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

        Cola n = new Cola();

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

        n.Print();
    }
}
