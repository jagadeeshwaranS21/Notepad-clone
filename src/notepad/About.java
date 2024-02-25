package notepad;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
public class About extends JFrame implements ActionListener{
    
    JButton b1;
    About(){
        setBounds(400,100,600,500);
        setLayout(null);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("About");
        
        ImageIcon i = new ImageIcon("C:\\Users\\jagad\\OneDrive\\Documents\\NetBeansProjects\\Notepad\\src\\notepad\\icons\\notepad.png");
        setIconImage(i.getImage());
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon image = new ImageIcon("C:\\Users\\jagad\\OneDrive\\Documents\\NetBeansProjects\\Notepad\\src\\notepad\\icons\\windows.png");
        Image im = image.getImage().getScaledInstance(300, 60, Image.SCALE_DEFAULT);
        ImageIcon  im2 = new ImageIcon(im);
        JLabel header = new JLabel(im2);
        header.setBounds(70,40,400,80);//adjust image position
        add(header);
        
        
        ImageIcon icon = new ImageIcon("C:\\Users\\jagad\\OneDrive\\Documents\\NetBeansProjects\\Notepad\\src\\notepad\\icons\\notepad.png");
        Image icon1 = icon.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon  icon2 = new ImageIcon(icon1);
        JLabel icon3 = new JLabel(icon2);
        icon3.setBounds(50,180,70,70);//adjust image position
        add(icon3);
        
        JLabel text = new JLabel("<html>All rights reserved<br><br>Notepad is a word processing program, <br>which allows changing of text in a computer file.<br>Notepad is a simple text editor for basic text-editing program<br> which enables computer users to create documents. </html>");
        text.setBounds(150,100,500,300);
        text.setFont(new Font("SAN SERIF",Font.PLAIN,16));
        add(text);
        
        b1 = new JButton("Close");
        b1.setBounds(150,350,120,25);
        add(b1);
        b1.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
            this.setVisible(false);    
    }
    public static void main(String args[]){
        new About().setVisible(true);
    }
}