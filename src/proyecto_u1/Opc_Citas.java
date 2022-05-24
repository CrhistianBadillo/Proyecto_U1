
package proyecto_u1;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Opc_Citas extends JFrame implements ActionListener {
    
    JLabel inf;
    
    JButton rea,ver;
    
    String NE,nom,ap,am,fe,doc,pro,pre,saldo,pag,datofecha,dia,mes,año;
    
     String [] orto={"Diagnostico","Brackets Metalicos","Brackets de ceramica","Brackets de zafiro","Ortodoncia Invisible"};
    String [] ortoP={"500","10000","12500","15000","16000"};
    
    String [] maxi={"Diagnostico","Extraccion de dientes","Drenaje de absesos","Implantes dentales","Cirugía ortognática"};
    String [] maxiP={"500","2000","2500","4750","7000"};
    
    String []edo={"Diagnostico","Endodoncia Unirradicular","Endodoncia Birradicular","Endodoncia Polirradicular","Chequo Post-Endodoncia"};
    String []edoP={"500","3000","4500","6000","750"};

    
    public Opc_Citas(){
        super("Opciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        
        
        inf=new JLabel("Que desea realizar");
        inf.setBounds(150,50,300,30);//x,y,ancho, alto
        inf.setFont(new Font("arial",Font.PLAIN,25));
        
        rea=new JButton("Agendar Cita");
        rea.setBounds(75,100,150,30);//x,y,ancho, alto

        
        ver=new JButton("Ver Citas Agendadas");
        ver.setBounds(275,100,175,30);//x,y,ancho, alto

        
        this.add(inf);
        this.add(rea);
        this.add(ver);
        
        ver.addActionListener(this);
        rea.addActionListener(this);
        
         this.getContentPane().setBackground(Color.WHITE);
    }
    
     public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton
              if(objeto==rea){
                int   respuesta= JOptionPane.showConfirmDialog(null,"¿Es la primera vez que el paciente viene?","Confirmacion",
                +JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
               if(respuesta==0){
                  JOptionPane.showMessageDialog(null,"Realice primero un expediente");
                  Expendientes obj= new Expendientes();
               }else if(respuesta==1){
                   Citas obj=new Citas();
               }

              }
              else if(objeto==ver){
                  Citas_Agendadas obj=new Citas_Agendadas();

              }
       }
       repaint();
    }
     


}
