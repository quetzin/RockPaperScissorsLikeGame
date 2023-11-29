package project3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;



public class GraphicalUserInterface extends JFrame implements ActionListener{
    
          
    private static final long serialVersionUID = 1L;
    JButton luteBtn, fireballBtn, shieldBtn;
    JPanel lp,rp;
    JList<String> playerList; //Should pass a String instead
    JLabel playerNameLabel, winRateLabel;
    private ArrayList<PlayerData> playerDataList;
    
    //----------------------------------------------------
    public GraphicalUserInterface(ArrayList<PlayerData> playerDataList) {           //Constructor for GUI
        this.playerDataList = playerDataList;
        JFrame frame = new JFrame("Fireball | Shield | Lute");
        JSplitPane sp = new JSplitPane();
        frame.add(sp);
        sp.setDividerLocation(300);

        
     // Create oDefaultListModel and populate it with PlayerData
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (PlayerData playerData : playerDataList) {
            if (playerData.getIsActive()) {
                listModel.addElement(playerData.getFirstName() + " " + playerData.getLastName());
            }
        }
        
        playerList = new JList<>(listModel);
        playerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        playerNameLabel = new JLabel("Player Name:");
        winRateLabel = new JLabel("Win Rate: ");
        

        
       // Creates the playerList panel
        lp = new JPanel(new BorderLayout());
        // This adds the playerList to the top of the leftPane
        lp.add(new JScrollPane(playerList), BorderLayout.NORTH);
        // labelsPanel is for Winrate and playerName
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        
        // adds both labels to the labelPanel
        labelsPanel.add(playerNameLabel);
        labelsPanel.add(winRateLabel);
        
        // This allows for both of the labels to be positioned vertically at the bottom
        lp.add(labelsPanel, BorderLayout.SOUTH);
        
        // Add the left pane to the left side of the split
        add(lp, BorderLayout.WEST);
        

        playerList.addListSelectionListener(e -> {
            String selectedPlayer = playerList.getSelectedValue();
            if (selectedPlayer != null) {
                PlayerData selected = getPlayerByName(playerDataList, selectedPlayer);
                if (selected != null) {
                playerNameLabel.setText(selected.getFirstName());
                winRateLabel.setText("Win Rate: " + selected.getWinRate() + "%");
                }
            }
        });
       

        // Add buttons 
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
        
        rp = new JPanel(null);
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
        String selectedPlayer = playerList.getSelectedValue();
        if (selectedPlayer != null) {
            PlayerData selected = getPlayerByName(playerDataList, selectedPlayer);
            if (selected != null) {
                if (e.getSource() == fireballBtn) {
                    // perform action for fireball btn using 'selected'
                    System.out.println("Fireball button clicked for player: " + selected.getFirstName());
                } else if (e.getSource() == shieldBtn) {
                    // perform action for shieldBtn using 'selected'
                    System.out.println("Shield button clicked for player: " + selected.getFirstName());
                } else if (e.getSource() == luteBtn) {
                    // Perform action for lute button using 'selected'
                    System.out.println("Lute button clicked for player: " + selected.getFirstName());
                }
            }
        }
    }


    public ArrayList<PlayerData> getPlayerDataList() {
        return playerDataList;
    }

    public void setPlayerDataList(ArrayList<PlayerData> playerDataList) {
        this.playerDataList = playerDataList;
    }
    
    private PlayerData getPlayerByName(ArrayList<PlayerData> playerDataList, String name) {
        for (PlayerData player : playerDataList) {
            if (player.getIsActive() && player.getFirstName().equals(name)) {
                return player;
            }
            
         }
        return null;
       }
    

}
