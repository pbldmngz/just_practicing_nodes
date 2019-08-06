//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
package Sort_Methods;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class Burbuja_Mejorada {
    //Parte usuario
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("\033[32mCantidad de datos a comparar\033[33m");
        int var = sc.nextInt();
        int a[] = new int[var];
        
        int k=0;
        for (int i = 0 ; i < a.length;i++)
        {
            k+=1;
            System.out.print("Número " + k + ": ");
            a[i] = sc.nextInt();
        }
        Burbuja(a);
        
    }
    //Parte útil
    static void Burbuja (int arreglo[])
    {
        int z=0;
        int y=0;
        int q=0;
        boolean n=false;
        for(int i = 0; i < arreglo.length - 1; i++)
        {
            for(int j = 0; j < arreglo.length - 1; j++)
            {
                if (arreglo[j] < arreglo[j + 1])
                {
                    int b = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = b;
                    
                }
                else{//Necesito algo bueno aquí
                    y++;
                    if (y>arreglo.length-(i-1))
                    {
                        n=true;
                    }
                }
            }
            q+=1;
            if(n){
                break;
            }
        }
        System.out.println("\033[35mNúmero de ciclos: " + q);
        //System.out.println("Z= " + z + " ,Y " + y);
        System.out.print("\033[36mOrdenados: ");
        for(int i=0 ; i<arreglo.length-1; i++){
            System.out.print(arreglo[i] + ", ");
        }
        System.out.println(arreglo[arreglo.length-1] + ".");
    }
}
//Idea: detectar si hay cambios en el arreglo en determinada vuelta