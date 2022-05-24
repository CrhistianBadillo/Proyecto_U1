
package proyecto_u1;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Usuario extends JFrame implements ActionListener{
    int ganancias, total;
    JLabel lblbien;
    JLabel lblusu;
    JLabel  lblcon;
    JLabel seg;
     ImageIcon imaSeg= new ImageIcon("C:\\Users\\Acer\\Downloads\\seg11.png");
    JTextField txtusu;
    JPasswordField con;
    JButton Ingresar;
    
    public Usuario(){
        super("Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(250,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        this.setBackground(Color.blue);
        setVisible(true);
        
  
        
        //etiquetas
        lblbien=new JLabel("Bienvenido");
        lblbien.setBounds(25,5,200,50);//x,y,ancho, alto
        lblbien.setFont(new Font("arial",Font.PLAIN,40));
        
        seg=new JLabel(imaSeg);
        seg.setBounds(25,40,200,148);//x,y,ancho, alto
        //Usuario
        lblusu=new JLabel("Usuario");
        lblusu.setBounds(10,170,100,30);//x,y,ancho, alto
        txtusu=new JTextField();
        txtusu.setBounds(10,200,200,30);//x,y,ancho, alto
        //Contraseña
        lblcon=new JLabel("Contraseña");
        lblcon.setBounds(10,230,100,30);//x,y,ancho, alto
        con=new JPasswordField();
        con.setBounds(10,260,200,30);//x,y,ancho, alto
        //boton ingreso
        Ingresar=new JButton("Ingresar");
        Ingresar.setBounds(75,320,100,30);//x,y,ancho, alto
        

        this.add(lblbien);
        this.add(lblusu);
        this.add(seg);
        this.add(txtusu);
        this.add(lblcon);
        this.add(con);
        this.add(Ingresar);
        
        Ingresar.addActionListener(this);
        
        this.getContentPane().setBackground(Color.WHITE);
  
    }
    
         public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       String Usu, Con,UP="Dueño123",CP="1234";
       
       
       Usu=txtusu.getText();
       Con=con.getText();
       
       if(objeto instanceof JButton){//si se pulso el boton
      
           if(Usu.equals(UP) && Con.equals(CP)){
            Finan_Datos fd;
            Finan_Cliente fc;
       try {
           fd = new Finan_Datos();
            fc =new Finan_Cliente();
           Enumeration e=fd.total();
           String d;
           while(e.hasMoreElements()){
               d=(String)e.nextElement();
                fc=fd.recuperar(d);
                
                String gan=fc.Pagado;
                
                int ganan=Integer.parseInt(gan);
                ganancias=(ganan);
                
                total+=ganancias;
                
                               
           }
       } catch (IOException ex) {
           Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Finanzas.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       JOptionPane.showMessageDialog(null,"Las ganancias son de: $"+total);
       this.setVisible(false);
            }
           else if(Usu!=UP && Con!=CP){
               JOptionPane.showMessageDialog(null,"Usuario y/o Contraseña Incorrecto");
           }
         
           
}
     }
    public static void main(String[] args) {
        Usuario obj= new Usuario();
        
    }

}
