
package proyecto_u1;

import java.util.*;
import java.io.*;
public class Exp_Cliente {
     private final String path="Exp_Cliente.obj";
     Hashtable <String,Pac_Expediente> tabla;
     
      public Exp_Cliente() throws IOException,ClassNotFoundException{
       FileInputStream fi;
        ObjectInputStream oi;
        
        try{
            /*El par�metro path tiene nombre del archivo e
             indica el camino hacia el directorio donde se encuentra el archivo
           las clases: FileInPutStream y ObjectInputStream prepara para leer del archivo*/
            fi = new FileInputStream(path);
            //para leer objetos del archivo
            oi = new ObjectInputStream(fi);
            //lee los objetos del archivo y los asigna a la tabla
            tabla = (Hashtable) oi.readObject();
            //cierre del archivo
            oi.close();
        }catch(FileNotFoundException e){
            /*Excepci�n que se produce cuando se produce un error al
             intentar tener acceso a un archivo que no existe en el disco.*/
            tabla = new Hashtable <String, Pac_Expediente> ();
        }
    }
    
    public boolean agregar(String nc,String Nom,String AP,String AM,String Edad,String Tel,String Dom){
       /*busca en la tabla la clave con la que se identifica al objeto
        sino existe se crea el objeto y se agrega a la tabla, mandando como
        argumentos la clave y al objeto (es decir la direccion de memoeria del objeto)*/
        if (!tabla.containsKey(nc)){
            Pac_Expediente Pe=new Pac_Expediente(nc,Nom,AP,AM,Edad,Tel,Dom);
            
            tabla.put(nc,Pe);
            //objeto para grabar 
            try {
            	/*las clases FileOutputStream y ObjectOutputStream,
            	 *a traves de sus objetos permiten grabar en el archivo fisico*/
            	 FileOutputStream fo = new FileOutputStream(path);
                    //este objeto es de escritura
                    ObjectOutputStream os = new ObjectOutputStream(fo);
                    //pasa lo que tiene la tabla al archivo fisico y lo graba
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
        /*busca en la tabla la clave con la que se identifica al objeto
        si existe se elimina de la tabla*/
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
    
    public Pac_Expediente recuperar(String nc){
        /*Se busca en la tabla la clave del objeto si se encuentra se
         recupera la direcci�n de memoria a trav�s del metodo get, sino existe
         se envia null (nulo)*/
        if (tabla.containsKey(nc)){
            return tabla.get(nc);
        }else{
            return null;
        }
    }
    
    public Enumeration total(){
    	/* recorre toda la tabla y envia todas las claves de los objetos*/
        return tabla.keys();
    }
    
    public void guardar() throws IOException{
    	/*Utiliza las clases,metodos correspondientes
    	 *para escribir (grabar) los objetos*/
        FileOutputStream fo = new FileOutputStream(path);
        ObjectOutputStream os = new ObjectOutputStream(fo);
        /*graba lo que tiene la tabla al archivo fisico y cierra el archivo*/
        os.writeObject(tabla);
        os.flush();
        os.close();
    }
}
