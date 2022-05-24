
package proyecto_u1;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Inter extends JFrame implements ActionListener{
    //imagen
    ImageIcon imagen= new ImageIcon("C:\\Users\\Acer\\Downloads\\diente_inchido111.png");
    ImageIcon imaAge= new ImageIcon("C:\\Users\\Acer\\Downloads\\agenda.png");
    ImageIcon imaFin= new ImageIcon("C:\\Users\\Acer\\Downloads\\fin1.png");
    ImageIcon imaExpe= new ImageIcon("C:\\Users\\Acer\\Downloads\\expe.png");
    ImageIcon imaReg= new ImageIcon("C:\\Users\\Acer\\Downloads\\regis1.png");
    
    //etiquetas
    JLabel lblCD,lblDD,diente,fecha,horas,agenda,expe,finanzas,registro;
    //botones
    JButton btnCitas,btnExp,btnFin,btnRegis;
    JPanel pnl;
    
    public Inter(){
        super("Clinica Dental Don Diente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,720);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        
        //fecha y hora

        
        Calendar fechas = new GregorianCalendar();
        int año = fechas.get(Calendar.YEAR);
        int mes = fechas.get(Calendar.MONTH)+1;
        int dia = fechas.get(Calendar.DAY_OF_MONTH);
        int hora = fechas.get(Calendar.HOUR_OF_DAY);
        int minuto = fechas.get(Calendar.MINUTE);
        
        String fe=(dia+"/"+mes+"/"+año);
        String ho=(hora+":"+minuto);
         
        //etiquetas interfaz principal
        fecha=new JLabel(fe);
        fecha.setBounds(780,1,200,50);//x,y,ancho, alto
        horas=new JLabel(ho);
        horas.setBounds(910,1,100,50);//x,y,ancho, alto
        lblCD=new JLabel("CLINICA DENTAL");
        lblCD.setBounds(50,10,700,100);//x,y,ancho, alto
        lblDD=new JLabel("DON DIENTE");
        lblDD.setBounds(400,110,700,100);//x,y,ancho, alto
        lblCD.setFont(new Font("bodoni mt black",Font.PLAIN,70));
        lblDD.setFont(new Font("bodoni mt black",Font.PLAIN,70));
        horas.setFont(new Font("arial",Font.PLAIN,25));
        fecha.setFont(new Font("arial",Font.PLAIN,25));
        //imagen
        diente=new JLabel(imagen);
        diente.setBounds(325,180,350,350);//x,y,ancho, alto
        //botones interfaz principal
        agenda=new JLabel(imaAge);
        agenda.setBounds(125,500,150,150);//x,y,ancho, alto
        btnCitas=new JButton("Citas");
        btnCitas.setBounds(100,650,200,30);//x,y,ancho, alto
        expe=new JLabel(imaExpe);
        expe.setBounds(425,500,150,150);//x,y,ancho, alto
        btnExp=new JButton("Expediente");
        btnExp.setBounds(400,650,200,30);//x,y,ancho, alto
        finanzas=new JLabel(imaFin);
        finanzas.setBounds(725,500,150,150);//x,y,ancho, alto
        btnFin=new JButton("Finanzas");
        btnFin.setBounds(700,650,200,30);//x,y,ancho, alto
        registro=new JLabel(imaReg);
        registro.setBounds(800,500,150,150);//x,y,ancho, alto
        btnRegis=new JButton("Registro");
        btnRegis.setBounds(775,650,200,30);//x,y,ancho, alto

         // agregar componentes interfaz principal
         this.add(fecha);
         this.add(horas);
         this.add(lblCD);
         this.add(lblDD);
         this.add(diente);
         this.add(agenda);
         this.add(expe);
         this.add(finanzas);
        // this.add(registro);
         this.add(btnCitas);
         this.add(btnExp);
         //this.add(btnRegis);
         this.add(btnFin);

         
        btnCitas.addActionListener(this);
        btnExp.addActionListener(this);
        btnFin.addActionListener(this);
        btnRegis.addActionListener(this);
        
        this.getContentPane().setBackground(Color.CYAN);
         

    }
     public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==btnCitas){
            Opc_Citas obj= new Opc_Citas();

         }
         else if(objeto==btnExp){
              Opc_Expe obj= new Opc_Expe();

         }
         else if(objeto==btnFin){
              Finanzas obj= new Finanzas();




         }
         else if(objeto==btnRegis){
             Registros obj= new Registros();

         }
             
    
}
     }
     public static void main(String[] args) {
        Inter obj= new Inter();
    }
}
     
