
package proyecto_u1;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Citas extends JFrame implements ActionListener {
    
    JLabel lblnom,lblap,lblam, lblfecha, lblhora,lbling, lbldoc;
    JTextField txtnom,txtap,txtam;
    JComboBox cbDia,cbMes, cbAño, cbHora, cbDoc;
    JButton Agregar;
    
    String[] dia= {"Dia","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
                    "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] mes= {"Mes","Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};
    String[] año= {"Año","2020","2021","2022"};
    String[] hora= {"Seleccione Hora","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30",
                     "16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30"};
    String[] doc={"Especialista","Ortodoncista","Maxilofacial","Endodoncista"};
    

    
    public Citas(){
        super("Citas");
        metodoVentana();
        metodoComponente();
        
    }
    
    public void metodoVentana(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(700,700);
        //ventana centrada en la pantalla
        this.setLocationRelativeTo(null);
        //no utilizar layout por default
        this.setLayout(null);
        //No redimension
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
        
    }
    
    private void metodoComponente(){
        lbling=new JLabel("Ingresar Cita");
        lbling.setBounds(300,70,150,30);//x,y,ancho, alto
        lbling.setFont(new Font("arial",Font.PLAIN,25));
        lblnom=new JLabel("Nombre(s) de paciente: ");
        lblnom.setBounds(150,100,150,30);
        txtnom=new JTextField();
        txtnom.setBounds(150,140,400,30);
        lblap=new JLabel("Apellido Paterno: ");
        lblap.setBounds(150,180,150,30);
        txtap=new JTextField();
        txtap.setBounds(150,220,400,30);
        lblam=new JLabel("Apellido Materno: ");
        lblam.setBounds(150,260,150,30);
        txtam=new JTextField();
        txtam.setBounds(150,300,400,30);
        lblfecha=new JLabel("Fecha");
        lblfecha.setBounds(150,340,150,30);
        cbDia=new JComboBox(dia);
        cbDia.setBounds(150,380,100,30);
        cbDia.setEditable(true);
        cbMes=new JComboBox(mes);
        cbMes.setBounds(260,380,100,30);
        cbMes.setEditable(true);
        cbAño=new JComboBox(año);
        cbAño.setBounds(370,380,100,30);
        cbAño.setEditable(true);
        lblhora=new JLabel("Hora");
        lblhora.setBounds(150,420,150,30);
        cbHora=new JComboBox(hora);
        cbHora.setBounds(150,460,150,30);
        cbHora.setEditable(true);
        lbldoc=new JLabel("Especialista");
        lbldoc.setBounds(350,420,150,30);
        cbDoc=new JComboBox(doc);
        cbDoc.setBounds(350,460,150,30);
        cbDoc.setEditable(true);
        Agregar=new JButton("Agregar");
        Agregar.setBounds(300, 550, 100, 30);

        this.add(lbling);        
        this.add(lblnom);
        this.add(txtnom);
        this.add(lblam);
        this.add(txtam);
        this.add(lblap);
        this.add(txtap);        
        this.add(lblfecha); 
        this.add(cbDia);        
        this.add(cbMes);
        this.add(cbAño);        
        this.add(lblhora);
        this.add(cbHora); 
        this.add(lbldoc);
        this.add(cbDoc);
        this.add(Agregar);
        
        Agregar.addActionListener(this);
        
    }
         public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==Agregar){
             String nom=txtnom.getText();
             String ap=txtap.getText();
             String am=txtam.getText();
             String Dia=(String)cbDia.getSelectedItem();
             String Mes=(String)cbMes.getSelectedItem();
             String Año=(String)cbAño.getSelectedItem();
             String Fecha=(Dia+"/"+Mes+"/"+Año);
             String Hora=(String)cbHora.getSelectedItem();
             String Doc=(String)cbDoc.getSelectedItem();
             int respuesta;
             
             
             
         if(Dia.equals("30") || Dia.equals("31")  && Mes.equals("Feb") && Año.equals("2020")){
             JOptionPane.showMessageDialog(null,"No se puede agregar ese día, ya que el mes de Febrero solo tiene 29 días."
                     + "Modifique la fecha");
         }    else
             
         if(nom.equals("") || ap.equals("") || am.equals("") || Dia.equals("Dia") || Mes.equals("Mes") || Año.equals("Año") ||
                Hora.equals("Seleccione Hora") || Doc.equals("Especialista")  ){
             JOptionPane.showMessageDialog(null,"No deje el espacio vacio y/o seleccione una opción correcta");
           }
                  
          else {
             respuesta= JOptionPane.showConfirmDialog(null,"Desea agregar la cita a la agenda.","Confirmacion",
                +JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
               if(respuesta==0){
                   try {
                    AgreCita();
                } catch (IOException ex) {
                    Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                dispose();
               }else if(respuesta==1){
                   
               }
         }
        
        
             
         }
             
    
}
     }
         
         public void AgreCita()throws IOException,ClassNotFoundException{
        Agenda_Citas ag=new Agenda_Citas();
        String nc;
        String nom=txtnom.getText();
        String ap=txtap.getText();
        String am=txtam.getText();
        String Dia=(String)cbDia.getSelectedItem();
        String Mes=(String)cbMes.getSelectedItem();
        String Año=(String)cbAño.getSelectedItem();
        String Fecha=(Dia+"/"+Mes+"/"+Año);
        String Hora=(String)cbHora.getSelectedItem();
        String Doc=(String)cbDoc.getSelectedItem();
        Random r =new Random();
        int ran=r.nextInt(1000);
        nc=Integer.toString(ran);
        
        ag.agregar(nc,txtnom.getText(), txtap.getText(), txtam.getText(),Fecha,Hora,Doc );
        
         JOptionPane.showMessageDialog(null,"Se ha agregado la siguiente informacion a la agenda:\n"+"Numero de Cliente: "+nc+
                      "\nNombre: "+nom+" "+ap+" "+am+"\nFecha: "+Fecha+"      Hora: "+
                       Hora+"\nEspecialista: "+Doc);
        ag.guardar();
        
    }
    
         
    public static void main(String[] args) {
        Citas obj= new Citas();
        
    }
}
