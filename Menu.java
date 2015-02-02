import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

/**
    Creates a GUI to display a menu on screen with
    choices for play game, instructions, and exit
 
    @author Jennifer Cryan
    @author  Jessica Huang
    @author  Jazarie Thach
    @author  Felica Truong
    @author  Josephine Vo
    @version for CS48, Winter 2015, UCSB
*/

class MainEnvironment extends JFrame {
    JFrame menuFrame;
    JFrame instructionsFrame;
    JButton Play;
    JButton Instructions;
    JButton Exit;
    JButton Back;
    Container c;
    
    // Calls displayMenu to menu on screen
    public static void main(String [] args) {
        Menu mainMenu = new Menu();
        mainMenu.displayMenu();
    }
    
    // Creates frame to display menu on screen
    public void displayMenu() {
        Play = "Play Game";
        Instructions = "How to Play";
        Exit = "Exit";
        
        menuFrame = new JFrame();
        menuFrame.setSize(1024, 768);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPanel = new JPanel();
        
        Play.setPreferredSize(new Dimension(250, 100));
        Instruction.setPreferredSize(new Dimension(250, 100));
        Exit.setPreferredSize(new Dimension(250, 100));
        
        Play.addActionListener(this);
        Instructions.addActionListener(this);
        Exit.addActionListener(this);
        
        super("SnakeTrain");
        c = new JLabel(/*background image*/);
        c.setLayout(new FlowLayout());
        c.add(Play);
        c.add(Instructions);
        c.add(Exit);
        add(Play);
        add(Instructions);
        add(Exit);
        pack();
        
        menuFrame.setVisible(true);
        
    }
    
    public void HowToPlay() {
        JPanel instructionsPanel = new JPanel();
        Back = new JButton("Main Menu");
        
        instructionsFrame = new JFrame();
        instructionsFrame.setSize(1024, 768);
        
        Back.addActionListener(this);
        Back.setPreferredSize(new Dimension(250, 100));
        
        instructionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instructionsFrame.getContentPane().add(instructionsPanel);
        Font font = new Font("Corsiva Hebrew", Font.PLAIN, 20);
        String s = "How to Play";
        
        public void paintCompnent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.GREEN);
            g2.fillRect(0, 0, this.getWidth(), this.getHeight());
            super.paintCompnent(g);
            
            /**  code for text formatting borrowed from http://stackoverflow.com/questions/13036057/display-text-in-swing-without-jlabel 
             */
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setFont(font);
            
            FontMetrics fm = g.getFontMetrics(font);
            
            int width = fm.stringWidth(s);
            
            Dimension d = getSize();
            
            //center String/text
            int cx = (d.width - width) / 2;
            int cy = (d.height - fm.getHeight()) / 2 + fm.getAscent();
            
            g2.drawString(s, cx, cy);
            
            
        }
        instructionsFrame.add(Back);
        instructionsFrame.pack();
        instructionsFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == Play) {
            menuFrame.setVisible(false);
            GameEnvironment SnakeTrain = new GameEnvironment();
        }
        if(event.getSource() == Instructions) {
            menuFrame.remove(Play);
            menuFrame.remove(Instructions);
            menuFrame.remove(Exit);
            menuFrame.remove(c);
            menuFrame.setVisible(false);
            HowToPlay();
        }
        if(event.getSource() == Exit) {
            System.exit(0);
        }
        if(event.getSource() == Back) {
            instructionsFrame.remove(Back);
            instructionsFrame.remove(instructionsPanel);
            instructionsFrame.setVisible(false);
            displayMenu();
        }
    }
    
}

    
    
    
