package project3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class GraphicalUserInterface implements ActionListener{
    
    //Code to add a fireball button. Work in progress:
    
            
    JButton luteBtn, fireballBtn, shieldBtn;
    JPanel lp,rp;
    
    public GraphicalUserInterface() {
        JFrame frame = new JFrame("Fireball | Shield | Lute");
        JSplitPane sp = new JSplitPane();
        frame.add(sp);
        sp.setDividerLocation(300);

        lp = new JPanel(null);
        rp = new JPanel(null);
        
        luteBtn = new JButton("Lute"); //Text for button
        fireballBtn = new JButton("Fireball");
        shieldBtn = new JButton("Shield");
//----------------------------------------------------
        luteBtn.setBounds(95, 20, 90, 40); // Set the bounds for the yellow button
        luteBtn.setBackground(Color.yellow); // Set the background color of the button to yellow
        luteBtn.addActionListener(this); // Add an action listener to the yellow button

        fireballBtn.setBounds(95, 70, 90, 40);
        fireballBtn.setBackground(Color.red);
        fireballBtn.addActionListener(this);
        
        shieldBtn.setBounds(95, 120, 90, 40);
        shieldBtn.setBackground(Color.blue);
        shieldBtn.addActionListener(this);
 //---------------------------------------------------   
        rp.add(luteBtn); //Puts button on right side
        rp.add(fireballBtn);
        rp.add(shieldBtn);
 //---------------------------------------------------      
        sp.setLeftComponent(lp);
        sp.setRightComponent(rp);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == luteBtn) {
            rp.setBackground(Color.yellow);
        }
        if(e.getSource() == fireballBtn) {
            rp.setBackground(Color.red);
        }
        if(e.getSource() == shieldBtn) {
            rp.setBackground(Color.blue);
        }
    }

    
       /* 
        button = new JButton();
        button.setBounds(100, 100, 250, 100);
        button.addActionListener(this);
        button.setText("Fireball");
        button.setFocusable(false);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        button.setBackground(Color.red);
        button.setFont(new Font("Comic Sans", Font.BOLD, 30));

    }

    //Event listener for fireball button:
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println("Replace this print statement with a method that should be\r\n" 
                    + "called to play a magic character against a\\r\\n\""
                    + " randomly generated opponent character");
        }
        
    }
    */

}
