
package proyecto_u1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Opc_Expe extends JFrame implements ActionListener{
     JLabel inf;
    
    JButton rea,ver;
    
    public Opc_Expe(){
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
        
        rea=new JButton("Realizar Nuevo Expediente");
        rea.setBounds(50,100,200,30);//x,y,ancho, alto

        
        ver=new JButton("Ver Expedientes");
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
                  Expendientes obj=new Expendientes();
              }
              else if(objeto==ver){
                  Expe_Creados obj = new Expe_Creados();
              }
       }
       repaint();
    }
}
