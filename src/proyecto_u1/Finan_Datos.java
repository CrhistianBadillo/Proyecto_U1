
package proyecto_u1;
import java.util.*;
import java.io.*;

public class Finan_Datos {
     private final String path="Finan_Datos.obj";
     Hashtable <String,Finan_Cliente> tabla;
     
     public Finan_Datos()throws IOException,ClassNotFoundException{
        FileInputStream fi;
        ObjectInputStream oi;
        
        try{

            fi = new FileInputStream(path);

            oi = new ObjectInputStream(fi);

            tabla = (Hashtable) oi.readObject();

            oi.close();
        }catch(FileNotFoundException e){

            tabla = new Hashtable <String, Finan_Cliente> ();
        }
    }
    
    public boolean agregar(String nc,String Nom,String AP,String AM,String Fe,String Do,String Pro,String Pre, String SalP,String Pag){

        if (!tabla.containsKey(nc)){
            Finan_Cliente c=new Finan_Cliente(nc,Nom,AP,AM,Fe,Do,Pro,Pre,SalP,Pag);
            
            tabla.put(nc,c);

            try {

            	 FileOutputStream fo = new FileOutputStream(path);

                    ObjectOutputStream os = new ObjectOutputStream(fo);

                os.writeObject(tabla);
                os.close();
                fo.close();
            }catch (IOException ex) {}
            return true;
        }else {
            return false;
        }
    }
    
    public boolean eliminar(String nc){

        if (tabla.containsKey(nc)){
            tabla.remove(nc);
            
            try{
            	FileOutputStream fo = new FileOutputStream(path);
                //este objeto es de escritura
                ObjectOutputStream os = new ObjectOutputStream(fo);
                os.writeObject(tabla);
                os.close();
                fo.close();
            }
            catch(IOException ex){}
            return true;
        }else{
            return false;
        }
    }
    
    public Finan_Cliente recuperar(String nc){

        if (tabla.containsKey(nc)){
            return tabla.get(nc);
        }else{
            return null;
        }
    }
    
    public Enumeration total(){
    	
        return tabla.keys();
    }
    
    public void guardar() throws IOException{

        FileOutputStream fo = new FileOutputStream(path);
        ObjectOutputStream os = new ObjectOutputStream(fo);

        os.writeObject(tabla);
        os.flush();
        os.close();
    
     }
}
