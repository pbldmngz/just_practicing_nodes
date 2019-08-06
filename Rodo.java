//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package Sort_Methods;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Rodo {
    Rodo sig;

    String data;
    String name;
    int prioridad;
    
    
    public Rodo(String name, String data, int var){
        this.data=data;
        this.name=name;
        
    }
    
    public void setSig(Rodo sig) {
        this.sig = sig;
    }

    public Rodo getSig() {
        return sig;
    }
    
    public void setDato(String dato){
        data=dato;
    }
    
/*    public void eliminate(){
        inicio=inicio.sig;
    }
*/
    @Override
    public String toString(){
        return name +" \033[33m"+data+" \033[31m       "+ prioridad+"\033[37m";
    }
}
