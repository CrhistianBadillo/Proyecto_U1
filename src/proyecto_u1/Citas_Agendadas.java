
package proyecto_u1;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Citas_Agendadas extends JFrame implements ActionListener {
    JLabel lbltit;
    JButton elim;
    String[] vector = new String[7];
    //Modelo de tabla para manipular el contenido
    DefaultTableModel dtm = new DefaultTableModel();


    public Citas_Agendadas(){
        super("Citas Agendadas");
        setSize(900,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
              
        //La tabla con el modelo DefaultTableModel
        final JTable miTabla = new JTable(dtm);
        
        dtm.addColumn("Numero de Cita");
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido Paterno");
        dtm.addColumn("Apellido Materno");
        dtm.addColumn("Fecha");
        dtm.addColumn("Hora");
        dtm.addColumn("Especialista");

        miTabla.setBackground(Color.WHITE);
        miTabla.setPreferredScrollableViewportSize(new Dimension(800,100));
        JScrollPane scrollpane = new JScrollPane(miTabla);
    
 
        lbltit=new JLabel("Citas Agendadas");
        lbltit.setFont(new Font("arial",Font.PLAIN,25));
        lbltit.setBounds(350,50,200,30);
        elim=new JButton("Eliminar Cita");
        elim.setBounds(350, 410, 200, 30);
        scrollpane.setBounds(100, 100, 700,100);
       


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
    
    public void actionPerformed(ActionEvent ev){
       Object obj=ev.getSource();
 

           if(obj==elim){
               eliminar();
               int respuesta;
               respuesta= JOptionPane.showConfirmDialog(null,"Se ELIMINARA la cita, desea continuar.","Eliminar",
                +JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
               if(respuesta==0){
                   JOptionPane.showMessageDialog(null,"Se ha eliminado la cita");
                   this.setVisible(false);
                   Citas_Agendadas ven=new Citas_Agendadas();
                   ven.setVisible(true);
               }
               
           }

   
        

    }
    
    public void Tabla(){
        String [] datos= new String[7];
        String d;
        
        Calendar fechas = new GregorianCalendar();
        int año = fechas.get(Calendar.YEAR);
        int mes = fechas.get(Calendar.MONTH)+1;
        int dia = fechas.get(Calendar.DAY_OF_MONTH);
        int hora = fechas.get(Calendar.HOUR_OF_DAY);
        int minuto = fechas.get(Calendar.MINUTE);
        
        try {
            Agenda_Citas ac= new Agenda_Citas();
            Cliente c =new Cliente();
            Enumeration e=ac.total();
            
            while(e.hasMoreElements()){
                d=(String)e.nextElement();
                c=ac.recuperar(d);
                datos[0]=c.NC;
                datos[1]=c.Nom;
                datos[2]=c.ApeP;
                datos[3]=c.ApeM;
                datos[4]=c.Fecha;
                datos[5]=c.Hora;
                datos[6]=c.Doc;
                guardar(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
            }
        } catch (IOException ex) {
            Logger.getLogger(Citas_Agendadas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Citas_Agendadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void eliminar(){
        String n=JOptionPane.showInputDialog(null,"Ingrese el número de cliente al que desea eliminar");
                   
        try {
            Agenda_Citas ac= new Agenda_Citas();
            ac.eliminar(n);
            ac.guardar();
            
        } catch (IOException ex) {
            Logger.getLogger(Citas_Agendadas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Citas_Agendadas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    
       

    
}
