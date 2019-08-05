//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package Libre;


/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Tarea {

    private String ar;
    private int pr;

    public Tarea(String ar, int pr) {
        this.ar = ar;
        this.pr = pr;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public int getPr() {
        return pr;
    }

    public void setPr(int pr) {
        this.pr = pr;
    }

    public String toString() {
        return "Tarea: " + ar + ", prioridad: " + pr;
    }
}
