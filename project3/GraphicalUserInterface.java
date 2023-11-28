package project3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;



public class GraphicalUserInterface extends JFrame implements ActionListener{
    
          
    private static final long serialVersionUID = 1L;
    JButton luteBtn, fireballBtn, shieldBtn;
    JPanel lp,rp;
    JList<PlayerData> playerList;
    JLabel playerNameLabel, winRateLabel;
    private ArrayList<PlayerData> playerDataList;
    
    //----------------------------------------------------
    public GraphicalUserInterface(ArrayList<PlayerData> playerDataList) {           //Constructor for GUI
        this.playerDataList = playerDataList;
        JFrame frame = new JFrame("Fireball | Shield | Lute");
        JSplitPane sp = new JSplitPane();
        frame.add(sp);
        sp.setDividerLocation(300);

        lp = new JPanel(null);
        rp = new JPanel(null);
        
     // Create oDefaultListModel and populate it with PlayerData
        DefaultListModel<PlayerData> listModel = new DefaultListModel<>();
        for (PlayerData playerData : playerDataList) {
            listModel.addElement(playerData);
        }
        
        playerList = new JList<>(listModel);
        playerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
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

    public ArrayList<PlayerData> getPlayerDataList() {
        return playerDataList;
    }

    public void setPlayerDataList(ArrayList<PlayerData> playerDataList) {
        this.playerDataList = playerDataList;
    }

}
