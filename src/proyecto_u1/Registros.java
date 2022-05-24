/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registros extends JFrame {
    
    JPanel orto= new JPanel();
    JPanel maxi= new JPanel();
    JPanel endo= new JPanel();
    
    JTabbedPane Reg= new JTabbedPane();
    public Registros(){
        super("Registros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,720);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        
        orto.setBackground(Color.cyan);
        Reg.addTab("Ortodoncista", orto);
    
        maxi.setBackground(Color.cyan);
        Reg.addTab("Maxilofacial", maxi);
         
        endo.setBackground(Color.cyan);
        Reg.addTab("Endodoncista", endo);
        
        setContentPane(Reg);
    }
}
