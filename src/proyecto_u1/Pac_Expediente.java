
package proyecto_u1;

import java.io.*;
public class Pac_Expediente implements Serializable  {
    String NC,Nom,ApeP,ApeM,Edad,Tel,Dom;
    int nc=0;
    
        public Pac_Expediente(){
        this.nc++;
        this.NC=Integer.toString(nc);
    }
        
        public Pac_Expediente(String nc,String Nom,String AP,String AM,String Edad,String Tel,String Dom){
        this.NC=nc;
        this.Nom=Nom;
        this.ApeP=AP;
        this.ApeM=AM;
        this.Edad=Edad;
        this.Tel=Tel;
        this.Dom=Dom;
    }
    
    public String getNC(){
        return NC;
    } 
}
