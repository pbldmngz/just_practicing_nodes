//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package Libre;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Nodo {

    private Tarea dato;
    private Nodo sig;
    private Nodo ant;

    public Nodo(Tarea dato) {
        this.dato = dato;
        /*this.sig = sig;
        this.ant = ant;*/
    }

    public Tarea getDato() {
        return dato;
    }

    public void setDato(Tarea dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

}
