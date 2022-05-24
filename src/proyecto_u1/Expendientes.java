
package proyecto_u1;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Expendientes extends JFrame implements ActionListener {
    JLabel lblnom,lblap,lblam,lblsex,lbldia,lblmes,lblaño,lbltel,lbldom,lbltit;
    JTextField txtnom,txtap,txtam,txtaño,txttel,txtdom;
    JComboBox sexo,cbDia,cbMes;
    JButton Agregar;
    
    String[] sex= {"Selccione su sexo","Masculino","Femenino"};
    
    String[] dia= {"Dia","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
                    "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] mes= {"Mes","Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};
    
    public Expendientes(){
        super("Expendientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,700);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        
        
        lbltit=new JLabel("Ingrese datos del paciente");
        lbltit.setBounds(200,70,300,30);//x,y,ancho, alto
        lbltit.setFont(new Font("arial",Font.PLAIN,25));
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
        lbldia=new JLabel("Dia de nacimiento");
        lbldia.setBounds(150,340,150,30);
        cbDia=new JComboBox(dia);
        cbDia.setBounds(150, 380, 100, 30);
        cbDia.setEditable(true);
        lblmes=new JLabel("Mes de nacimiento");
        lblmes.setBounds(300,340,150,30);
        cbMes=new JComboBox(mes);
        cbMes.setBounds(300, 380, 100, 30);
        cbMes.setEditable(true);
        lblaño=new JLabel("Año de Nacimiento");
        lblaño.setBounds(440,340,150,30);
        txtaño=new JTextField();
        txtaño.setBounds(450,380,100,30);
        lblsex=new JLabel("Sexo");
        lblsex.setBounds(150,420,150,30);
        sexo=new JComboBox(sex);
        sexo.setBounds(150,460,150,30);
        sexo.setEditable(true);
        lbltel=new JLabel("Telefono: ");
        lbltel.setBounds(400,420,150,30);
        txttel=new JTextField();
        txttel.setBounds(400,460,150,30);
        lbldom=new JLabel("Domicilio");
        lbldom.setBounds(150,500,150,30);
        txtdom=new JTextField();
        txtdom.setBounds(150,540,400,30);
        Agregar= new JButton("Agregar");
        Agregar.setBounds(300, 580, 100, 30);
        
        
        this.add(lbltit);        
        this.add(lblnom);
        this.add(txtnom);
        this.add(lblam);
        this.add(txtam);
        this.add(lblap);
        this.add(txtap);        
        this.add(lbldia); 
        this.add(cbDia);   
        this.add(lblmes); 
        this.add(cbMes);
        this.add(lblaño); 
        this.add(txtaño);  
        this.add(lblsex);
        this.add(sexo);
        this.add(lbltel); 
        this.add(txttel);     
        this.add(lbldom);
        this.add(txtdom);
        this.add(Agregar);
        
        Agregar.addActionListener(this);
        
        this.getContentPane().setBackground(Color.CYAN);
        

    }
    
             public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==Agregar){
             //fecha actual
             Calendar fechas = new GregorianCalendar();
             int añoC = fechas.get(Calendar.YEAR);
             int mesC = fechas.get(Calendar.MONTH)+1;
             int diaC = fechas.get(Calendar.DAY_OF_MONTH);
             String nom=txtnom.getText();
             String ap=txtap.getText();
             String am=txtam.getText();
             String Dia=(String)cbDia.getSelectedItem();
             String Mes=(String)cbMes.getSelectedItem();
             String Año=txtaño.getText();
             //datos paciente convertidos en enteros
             int añoP=0;
             int diaP=cbDia.getSelectedIndex();
             int mesP=cbMes.getSelectedIndex();
             añoP=Integer.parseInt(Año);
             //edad del paciente actualmente
             int añoR=(añoC-añoP);
             int mesR=(mesC-mesP);
             int añoT=0;
             int ta=Año.length();
             
             if(mesR<0){
                 añoT=(añoR-1);
             }else{
                 añoT=añoR; 
            }
                         
             String Fecha=(Dia+"/"+Mes+"/"+Año);
             String Edad=Integer.toString(añoT);
             String Tel=txttel.getText();
             String Dom=txtdom.getText();
             int respuesta;
           
             
         if(ta!=4 || añoP>añoC){
             JOptionPane.showMessageDialog(null,"Coloque correctamente el año de nacimiento");
        } else  
             if(nom.equals("") || ap.equals("") || am.equals("") || Dia.equals("Dia") || Mes.equals("Mes") || Año.equals("") ||
                Tel.equals("") || Dom.equals("") ){
             JOptionPane.showMessageDialog(null,"No deje el espacio vacio y/o seleccione una opción correcta");

             }
             
                  
          else {
             
             respuesta= JOptionPane.showConfirmDialog(null,"Desea agregar el expediente del paciente.","Confirmacion",
                +JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
              if(respuesta==0){
                  try {
                    AgreExp();
                } catch (IOException ex) {
                    Logger.getLogger(Expendientes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Expendientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                dispose(); 
 
               }else if(respuesta==1){
                   
               }
         }
        
        
             
         }
             
       }
             }
             
             
             
             
 public void AgreExp()throws IOException,ClassNotFoundException{
        Exp_Cliente ag=new Exp_Cliente();
        String nc;
        Calendar fechas = new GregorianCalendar();
             int añoC = fechas.get(Calendar.YEAR);
             int mesC = fechas.get(Calendar.MONTH)+1;
             int diaC = fechas.get(Calendar.DAY_OF_MONTH);
             String nom=txtnom.getText();
             String ap=txtap.getText();
             String am=txtam.getText();
             String Dia=(String)cbDia.getSelectedItem();
             String Mes=(String)cbMes.getSelectedItem();
             String Año=txtaño.getText();
             //datos paciente convertidos en enteros
             int diaP=cbDia.getSelectedIndex();
             int mesP=cbMes.getSelectedIndex();
             int añoP=Integer.parseInt(Año);
             //edad del paciente actualmente
             int añoR=(añoC-añoP);
             int mesR=(mesC-mesP);
             int añoT=0;
             int ta=Año.length();
             
             if(mesR<0){
                 añoT=(añoR-1);
             }else{
                 añoT=añoR; 
            }
                         
             String Fecha=(Dia+"/"+Mes+"/"+Año);
             String Edad=Integer.toString(añoT);
             String Tel=txttel.getText();
             String Dom=txtdom.getText();
             
        Random r =new Random();
        int ran=r.nextInt(1000);
        nc=Integer.toString(ran);
        
        ag.agregar(nc,nom,ap,am,Edad,Tel,Dom );
        
         JOptionPane.showMessageDialog(null,"Se ha agregado la siguiente informacion a la agenda:\n"+"Numero de Cliente: "+nc+
                      "\nNombre: "+nom+" "+ap+" "+am+"\nEdad: "+Edad+"\nTelefono: "+
                       Tel+"\nDomicilio: "+Dom);
        ag.guardar();
        
    }
    
             
             
             
     }

