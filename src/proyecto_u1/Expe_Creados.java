
package proyecto_u1;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Expe_Creados extends JFrame implements ActionListener {

    String[] vector = new String[7];
    //Modelo de tabla para manipular el contenido
    JLabel lbltit;
    JButton elim;
        
    DefaultTableModel dtm = new DefaultTableModel();
    
    public Expe_Creados(){
        super("Expedientes");
        setSize(900,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
                      

        //La tabla con el modelo DefaultTableModel
        final JTable miTabla = new JTable(dtm);
        
        
        dtm.addColumn("Numero de Exp.");
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido Paterno");
        dtm.addColumn("Apellido Materno");
        dtm.addColumn("Edad");
        dtm.addColumn("Telefono");
        dtm.addColumn("Domicilio");
        
        miTabla.setBackground(Color.WHITE);
        miTabla.setPreferredScrollableViewportSize(new Dimension(700,100));
        JScrollPane scrollpane = new JScrollPane(miTabla);

        
        lbltit=new JLabel("Expedientes Creados");
        lbltit.setFont(new Font("arial",Font.PLAIN,25));
        lbltit.setBounds(325,50,250,30);
        elim=new JButton("Eliminar Expediente");
        elim.setBounds(350, 410, 200, 30);
        scrollpane.setBounds(100, 100, 700,300);

         this.add(lbltit);
         this.add(scrollpane);  
         this.add(elim);

        elim.addActionListener(this);


        Tabla();
        
        this.getContentPane().setBackground(Color.CYAN);
    }
    
     public void guardar(String cero,String uno,String dos,String tres,String cuatro,String cinco,String seis){
        vector[0]=cero;
        vector[1]=uno;
        vector[2]=dos;
        vector[3]=tres;
        vector[4]=cuatro;
        vector[5]=cinco;
        vector[6]=seis;
        dtm.addRow(vector);
    }
     
      public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        
                   if(obj==elim){
               eliminar();
               int respuesta;
               respuesta= JOptionPane.showConfirmDialog(null,"Se ELIMINARA el expediente, desea continuar.","Eliminar",
                +JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
               if(respuesta==0){
                   JOptionPane.showMessageDialog(null,"Se ha eliminado el expediente");
                   this.setVisible(false);
                   Expe_Creados ven=new Expe_Creados();
                   ven.setVisible(true);
               }
               
           }
  

    }
      
      
      public void Tabla(){
        String [] datos= new String[7];
        String d;
        
        try {
            Exp_Cliente ec= new Exp_Cliente();
            Pac_Expediente pe =new Pac_Expediente();
            Enumeration e=ec.total();
            
            while(e.hasMoreElements()){
                d=(String)e.nextElement();
                pe=ec.recuperar(d);
                datos[0]=pe.NC;
                datos[1]=pe.Nom;
                datos[2]=pe.ApeP;
                datos[3]=pe.ApeM;
                datos[4]=pe.Edad;
                datos[5]=pe.Tel;
                datos[6]=pe.Dom;
                guardar(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
            }
        } catch (IOException ex) {
            Logger.getLogger(Citas_Agendadas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Citas_Agendadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
       public void eliminar(){
        String n=JOptionPane.showInputDialog(null,"Ingrese el número de expediente al que desea eliminar");
                   
        try {
            Exp_Cliente ec= new Exp_Cliente();
            ec.eliminar(n);
            ec.guardar();
            
        } catch (IOException ex) {
            Logger.getLogger(Citas_Agendadas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Citas_Agendadas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
