/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NextLVL;

/**
 *
 * @author maria
 */
public class ColaDeImpresion2{
     
    private Nodo inicio;
    
    
    public void agregar(Tarea t){
    
       Nodo nodo =new Nodo(t);
       if(inicio==null){
           inicio=nodo;
       }
       else{
           
           Nodo aux=inicio;              
           
       while(aux!=null){
            Tarea n=aux.getDato();
            Tarea s=nodo.getDato();  
           
          if(aux==inicio){
             if(n.getPr()>=s.getPr()){
               aux.setAnt(nodo);
               nodo.setSig(aux);
               
               inicio=nodo;
               break; 
             }
          } 
           if(n.getPr()>=s.getPr()){
               aux.setAnt(nodo);
               nodo.setSig(aux);
                              
               break;
               
           }
           else{
               if(n.getPr()<=s.getPr()){
                 
                  nodo.setAnt(aux);
                   nodo.setSig(aux.getSig());
                   aux.setSig(nodo);
               break; 
               }
               else{
                   aux=aux.getSig();
               }
           }
        }
       }     
    }
    public void borrar(){
        Nodo aux=inicio;
       // System.out.println(aux.getDato());
        Nodo n=aux.getSig();
         aux=null;
        inicio=n;
       
       
    }
    public void imprime(){
        
        Nodo aux=inicio;
         while(aux!=null){
        
        System.out.println(aux.getDato());
        aux=aux.getSig();
        }
    }
    
    public static void main(String arg[]){
        Tarea tarea1=new Tarea("a",2); 
        Tarea tarea3=new Tarea("b",3);
        Tarea tarea2=new Tarea("c",1);
        Tarea tarea4=new Tarea("d",2); 
        Tarea tarea5=new Tarea("e",3);
        Tarea tarea6=new Tarea("f",1);
        
        ColaDeImpresion2 n=new ColaDeImpresion2();
        n.agregar(tarea1);
        n.agregar(tarea2);
        n.agregar(tarea3);
        n.agregar(tarea4);
        n.agregar(tarea5);
        n.agregar(tarea6);
        
      // n.imprime();
       //n.borrar();
        n.imprime();
    }
}
