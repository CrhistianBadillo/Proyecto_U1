
package proyecto_u1;
import java.io.*;

public class Finan_Cliente implements Serializable {
    String NC,Nom,ApeP,ApeM,Fecha,Doc,Procedimento,Precio,SaldoP,Pagado;
    int nc=0;
    
    public Finan_Cliente(){
        this.nc++;
        this.NC=Integer.toString(nc);
    }
    
    public Finan_Cliente(String nc,String Nom,String AP,String AM,String Fe,String Do,String Pro,String Pre, String SalP,String Pag){
        this.NC=nc;
        this.Nom=Nom;
        this.ApeP=AP;
        this.ApeM=AM;
        this.Fecha=Fe;
        this.Doc=Do;
        this.Procedimento=Pro;
        this.Precio=Pre;
        this.SaldoP=SalP;
        this.Pagado=Pag;
    }
    
    public String getNC(){
        return NC;
    } 
}
