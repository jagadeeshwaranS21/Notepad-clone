package notepad;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.*;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {
    
    JTextArea area;
    String text;
    
    Notepad(){
        setVisible(true);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);    //Fullscreen
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Notepad");
        ImageIcon icon = new ImageIcon("C:\\Users\\jagad\\OneDrive\\Documents\\NetBeansProjects\\Notepad\\src\\notepad\\icons\\notepad.PNG");
        setIconImage(icon.getImage());
        //getContentPane().setBackground(Color.white);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        menubar.setBackground(Color.white);
        
        JMenu File = new JMenu("File");
        File.setFont(new Font("AERIAL",Font.PLAIN,14));
        menubar.add(File);
        
        JMenuItem New = new JMenuItem("New");
        File.add(New);
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        New.addActionListener(this);
        
        JMenuItem Open = new JMenuItem("Open");
        File.add(Open);
        Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        Open.addActionListener(this);
        
        JMenuItem Save = new JMenuItem("Save");
        File.add(Save);
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        Save.addActionListener(this);
        
        JMenuItem Print = new JMenuItem("print");
        File.add(Print);
        Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        Print.addActionListener(this);
        
        JMenuItem Exit = new JMenuItem("Exit");
        File.add(Exit);
        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,ActionEvent.CTRL_MASK));
        Exit.addActionListener(this);
        
        JMenu Edit = new JMenu("Edit");
        Edit.setFont(new Font("AERIAL",Font.PLAIN,14));
        menubar.add(Edit);
        
        JMenuItem Copy = new JMenuItem("Copy");
        Edit.add(Copy);
        Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        Copy.addActionListener(this);
        
        JMenuItem Paste = new JMenuItem("Paste");
        Edit.add(Paste);
        Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        Paste.addActionListener(this);
        
        JMenuItem Cut = new JMenuItem("Cut");
        Edit.add(Cut);
        Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        Cut.addActionListener(this);
        
        JMenuItem Select_All = new JMenuItem("Select All");
        Edit.add(Select_All);
        Select_All.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        Select_All.addActionListener(this);
        
        JMenu Help = new JMenu("Help");
        Help.setFont(new Font("AERIAL",Font.PLAIN,14));
        menubar.add(Help);
        JMenuItem About = new JMenuItem("About");
        About.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        Help.add(About);
        About.addActionListener(this);
        
        area = new JTextArea();
        add(area);
        area.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        
        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //addActionlistener(this) internnally calls actionPerformed() method 
        if(e.getActionCommand().equals("New")){
            area.setText("");
        }
        
        if(e.getActionCommand().equals("Open")){
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files","txt");
            chooser.addChoosableFileFilter(restrict);
            int action = chooser.showOpenDialog(this);
            if(action !=JFileChooser.APPROVE_OPTION){
                return;
            }
            File file = chooser.getSelectedFile();
            try{
                BufferedReader reader = new BufferedReader(new FileReader(file));
                area.read(reader, null);
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        
        if(e.getActionCommand().equals("Save")){
            JFileChooser saveas = new JFileChooser();
            saveas.setApproveButtonText("save");
            
            int action = saveas.showOpenDialog(this);
            
            if(action!=JFileChooser.APPROVE_OPTION){
                return;
            }
            
            File filename = new File(saveas.getSelectedFile()+".txt");
            BufferedWriter outFile =null;
            try{
                outFile = new BufferedWriter(new FileWriter(filename));
                area.write(outFile);
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        
        if(e.getActionCommand().equals("Print")){
            try{
                area.print();
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        
        if(e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
        
        if(e.getActionCommand().equals("Copy")){
            text = area.getSelectedText();
        }
        
        if(e.getActionCommand().equals("Paste")){
            area.insert(text,area.getCaretPosition());
        }
        
        if(e.getActionCommand().equals("Cut")){
            text = area.getSelectedText();
            area.replaceRange("",area.getSelectionStart(),area.getSelectionEnd());
        }
        
        if(e.getActionCommand().equals("Select All")){
            area.selectAll();
            
        }
        
        if(e.getActionCommand().equals("About")){
            new About().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Notepad();
    }
}    