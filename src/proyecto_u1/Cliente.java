
package proyecto_u1;
import java.io.*;
public class Cliente implements Serializable {
    String NC,Nom,ApeP,ApeM,Fecha,Hora,Doc;
    int nc=0;
    
    
    public Cliente(){
        this.nc++;
        this.NC=Integer.toString(nc);
    }
    
    public Cliente(String nc,String Nom,String AP,String AM,String Fe,String Ho,String Do){
        this.NC=nc;
        this.Nom=Nom;
        this.ApeP=AP;
        this.ApeM=AM;
        this.Fecha=Fe;
        this.Hora=Ho;
        this.Doc=Do;
    }
    
    public String getNC(){
        return NC;
    } 
}
