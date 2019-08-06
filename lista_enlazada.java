//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package Sort_Methods;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class lista_enlazada {

    static int nameCTRL = 0;
    public static ArrayList <Nodo> nodos = new ArrayList <Nodo>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int l = 10;
        int ndL = 0;
        int prAbs = 0;
        int h = 0;
        boolean r = true;
        String LTribunal;

        for (int i = 0; i < l; i++) {
            nodos.add(new Nodo(nameGen(), prioGen(), dataGen(), nameCTRL));
        }

        do {
            System.out.println("Cuantos nodos desea añadir?");
            ndL = sc.nextInt();
            for (int i = 0; i < ndL; i++) {
                System.out.println("Inserte prioridad (1 es la más alta) del nodo " + i + ": ");
                prAbs = sc.nextInt();
                nodos.add(new Nodo(nameGen(), prAbs, dataGen(), nameCTRL));
            }

            Clasificador();

            while (h < nodos.size() - 1) {
                nodos.get(h).setSig(nodos.get(h + 1));
                h++;
            }

            System.out.println("\033[36mNAME    DATA                           PRIORITY\033[37m");
            for (int i = 0; i < nodos.size(); i++) {
                System.out.println(nodos.get(i));
            }

            System.out.println("PRESS F TO END, ANYTHING TO CONTINUE");
            LTribunal = sc.next();

            if (LTribunal.equalsIgnoreCase("f")) {
                r = false;
            }

        } while (r == true);
        System.out.println("Fin del programa");
    }

    public static void Clasificador() {
        int posM;
        Nodo Skillet;
        for (int i = 0; i < nodos.size(); i++) {
            posM = nodos.size() - 1;
            for (int n = i; n < nodos.size(); n++) {
                if(nodos.get(n).prioridad==nodos.get(posM).prioridad)
                {
                    if (nodos.get(n).tiempo<nodos.get(posM).tiempo)
                    {
                       posM = n; 
                    }
                }
                else if (nodos.get(n).prioridad < nodos.get(posM).prioridad) {
                    posM = n;
                }
                
            }
            Skillet = nodos.get(posM);
            nodos.set(posM, nodos.get(i));
            nodos.set(i, Skillet);
        }
    }

    public static String nameGen() {
        nameCTRL += 1;
        String arv = "";
        if (nameCTRL < 10) {
            arv = "  ";
        }
        if (nameCTRL < 100 && nameCTRL > 9) {
            arv = " ";
        }
        
        return "File" + nameCTRL + arv;
    }

    public static int prioGen() {
        int gen = (int) (Math.random() * 3) + 1;
        return gen;
    }

    public static String dataGen() {
        char ch;
        String data = "";
        for (int i = 1; i <= 25; i++) {
            int g = (int) (Math.random() * 200) + 33;
            ch = (char) g;
            data = data + "" + ch;
            if (i % 5 == 0) {
                data = data + " ";
            }
        }
        return data;
    }

}
