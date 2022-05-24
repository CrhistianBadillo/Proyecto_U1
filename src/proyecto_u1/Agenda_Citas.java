
package proyecto_u1;
import java.util.*;
import java.io.*;

public class Agenda_Citas  {
    
     private final String path="Agenda_Citas.obj";
     Hashtable <String,Cliente> tabla;
    
    public Agenda_Citas() throws IOException,ClassNotFoundException{
       FileInputStream fi;
        ObjectInputStream oi;
        
        try{
            
            fi = new FileInputStream(path);

            oi = new ObjectInputStream(fi);

            tabla = (Hashtable) oi.readObject();

            oi.close();
        }catch(FileNotFoundException e){

            tabla = new Hashtable <String, Cliente> ();
        }
    }
    
    public boolean agregar(String nc,String Nom,String AP,String AM,String Fe,String Ho,String Do){
 
        if (!tabla.containsKey(nc)){
            Cliente c=new Cliente(nc,Nom,AP,AM,Fe,Ho,Do);
            
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
    
    public Cliente recuperar(String nc){

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
