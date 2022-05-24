
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

public class Finanzas extends JFrame implements ActionListener {
   JButton btnAbo,btnLiq,btnGan;
    String[] vector = new String[10];
    //Modelo de tabla para manipular el contenido
    DefaultTableModel dtm = new DefaultTableModel();
    
    JLabel lbltit;
    
    String NE,nom,ap,am,fe,doc,pro,pre,saldo,pag;
    
     String [] orto={"Diagnostico","Brackets Metalicos","Brackets de ceramica","Brackets de zafiro","Ortodoncia Invisible"};
    String [] ortoP={"500","10000","12500","15000","16000"};
    
    String [] maxi={"Diagnostico","Extraccion de dientes","Drenaje de absesos","Implantes dentales","Cirugía ortognática"};
    String [] maxiP={"500","2000","2500","4750","7000"};
    
    String []edo={"Diagnostico","Endodoncia Unirradicular","Endodoncia Birradicular","Endodoncia Polirradicular","Chequo Post-Endodoncia"};
    String []edoP={"500","3000","4500","6000","750"};

    
    
    public Finanzas(){
        super("Finanzas");
       
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           setSize(1000,600);
           setLocationRelativeTo(null);
           setVisible(true);
           setLayout(null);
           
           
           final JTable miTabla = new JTable(dtm);
           
           dtm.addColumn("No. de Cita.");
           dtm.addColumn("Nombre");
           dtm.addColumn("Apellido Paterno");
           dtm.addColumn("Apellido Materno");
           dtm.addColumn("Fecha");
           dtm.addColumn("Especialista");
           dtm.addColumn("Procedimiento");
           dtm.addColumn("Precio");
           dtm.addColumn("Saldo Pendiente");
           dtm.addColumn("Pagado");
           
           miTabla.setBackground(Color.WHITE);
           miTabla.setPreferredScrollableViewportSize(new Dimension(800,100));
           JScrollPane scrollpane = new JScrollPane(miTabla);
           
           lbltit=new JLabel("Finanzas");
           lbltit.setFont(new Font("arial",Font.PLAIN,25));
           lbltit.setBounds(400,50,200,30);
           btnAbo=new JButton("Abonar");
           btnAbo.setBounds(100, 500, 200, 30);
           btnLiq=new JButton("Liquidar");
           btnLiq.setBounds(400, 500, 200, 30);
           scrollpane.setBounds(25, 100, 950,300);
           btnGan=new JButton("Ganancias");
           btnGan.setBounds(700, 500, 200, 30);
           scrollpane.setBounds(25, 100, 950,300);
           
           this.add(lbltit);
           this.add(scrollpane);
           this.add(btnAbo);
           this.add(btnLiq);
           this.add(btnGan);
           
           btnAbo.addActionListener(this);
           btnLiq.addActionListener(this);
           btnGan.addActionListener(this);
       try {
           guarDatos();
       } catch (IOException ex) {
           Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
       }
           Tabla();

           this.getContentPane().setBackground(Color.CYAN);
    }
    
          public void guardar(String cero,String uno,String dos,String tres,String cuatro,String cinco,
                  String seis,String siete,String ocho,String nueve){
        vector[0]=cero;
        vector[1]=uno;
        vector[2]=dos;
        vector[3]=tres;
        vector[4]=cuatro;
        vector[5]=cinco;
        vector[6]=seis;
        vector[7]=siete;
        vector[8]=ocho;
        vector[9]=nueve;
        dtm.addRow(vector);
    }
    
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        
        if(obj==btnAbo){
            String n=JOptionPane.showInputDialog(null,"Ingrese el número de expediente al que desea abonar");
            String na=JOptionPane.showInputDialog(null,"¿Cuánto dinero abonara?");
            int abono=Integer.parseInt(na);
            
            Finan_Cliente fc=new Finan_Cliente();
            Finan_Datos fd;
            try {
                fd = new Finan_Datos();
                fc=fd.recuperar(n);
                String din=fc.Precio;
                int dinero=Integer.parseInt(din);
                
                int saldopen=(dinero-abono);
                String Sp=Integer.toString(saldopen);
                
                String pa=fc.Pagado;
                int paga=Integer.parseInt(pa);
                
                int total=(paga+abono);
                String toPag=Integer.toString(total);
                
                fc.SaldoP=Sp;
                fc.Pagado=toPag;
                fd.guardar();
                
                  this.setVisible(false);
                   Finanzas ven=new Finanzas();
                   ven.setVisible(true);
                   
                   
                
            } catch (IOException ex) {
                Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        
        if(obj==btnLiq){
            String n=JOptionPane.showInputDialog(null,"Ingrese el número de expediente al que desea liquidar");
            Finan_Cliente fc=new Finan_Cliente();
            Finan_Datos fd;
            try {
               fd = new Finan_Datos();
                fc=fd.recuperar(n);
                String din=fc.SaldoP;
                int dinero=Integer.parseInt(din);
                
                int saldopen=(dinero-dinero);
                String Sp=Integer.toString(saldopen);
                
                String pa=fc.Pagado;
                int paga=Integer.parseInt(pa);
                
                int total=(paga+dinero);
                String toPag=Integer.toString(total);
                
                fc.SaldoP=Sp;
                fc.Pagado=toPag;
                fd.guardar();
                
                  this.setVisible(false);
                   Finanzas ven=new Finanzas();
                   ven.setVisible(true);
                   
                   
                
            } catch (IOException ex) {
                Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        }
        
        if(obj==btnGan){
            Usuario ob= new Usuario();
        }

    }
    
     public void Tabla(){
        String [] datos= new String[10];
        String d;

        
        try {

            Finan_Datos fd= new Finan_Datos();
            Finan_Cliente c =new Finan_Cliente();
            Enumeration e=fd.total();

            
            while(e.hasMoreElements()){
                d=(String)e.nextElement();
                c=fd.recuperar(d);
                  
                datos[0]=c.NC;
                datos[1]=c.Nom;
                datos[2]=c.ApeP;
                datos[3]=c.ApeM;
                datos[4]=c.Fecha;
                datos[5]=c.Doc;
                datos[6]=c.Procedimento;
                datos[7]=c.Precio;
                datos[8]=c.SaldoP;
                datos[9]=c.Pagado;
                guardar(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7],datos[8],datos[9]);
            }
        } catch (IOException ex) {
            Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     

      
      public void guarDatos() throws IOException, ClassNotFoundException{
                  
        Finan_Datos fd;
        fd= new Finan_Datos();
        
        Random r =new Random();
        int ran=r.nextInt(4);  
        int paga=0;
        String pagado=Integer.toString(paga);

          Agenda_Citas ac;
            Exp_Cliente ec;
       try {
           ac = new Agenda_Citas();
           Cliente c =new Cliente();
           Enumeration e=ac.total();
           String d;
           while(e.hasMoreElements()){
               d=(String)e.nextElement();
                c=ac.recuperar(d);

                 NE=c.NC;
                 nom=c.Nom;
                 ap=c.ApeP;
                 am=c.ApeM;
                 fe=c.Fecha;
                 doc=c.Doc;
                 
                 if(doc.equals("Endodoncista")){
                     pro=edo[ran];
                     pre=edoP[ran];
                 }else if(doc.equals("Maxilofacial")){
                     pro=maxi[ran];
                     pre=maxiP[ran];
                 }else if(doc.equals("Ortodoncista")){
                    pro=orto[ran];
                     pre=ortoP[ran]; 
                 }
                 
                 saldo=pre;
                 pag=pagado;
                 
                fd.agregar(NE, nom, ap, am, fe, doc, pro, pre, saldo, pag);
                fd.guardar();
                 
           }
       } catch (IOException ex) {
           Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
       }
       


        
      }
     
    
        

    
}
