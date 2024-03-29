//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package Sort_Methods;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Nodo {
    Nodo sig;

    String data;
    String name;
    int prioridad;
    int tiempo;
    
    
    
    public Nodo(String name, int pri, String data, int var){
        this.data=data;
        this.name=name;
        prioridad=pri;
        tiempo=var;
        
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getSig() {
        return sig;
    }
    
    public void setDato(String dato){
        data=dato;
    }
    
    @Override
    public String toString(){
        return name +" \033[33m"+data+" \033[31m       "+ prioridad+"\033[37m";
    }
}
