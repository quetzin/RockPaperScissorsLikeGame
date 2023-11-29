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



public class GraphicalUserInterface extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JButton luteBtn, fireballBtn, shieldBtn;
    JPanel lp, rp;
    JList<String> playerList; // Should pass a String instead
    JLabel playerNameLabel, winRateLabel;
    private ArrayList<PlayerData> playerDataList;

    // Constructor for the GUI
    public GraphicalUserInterface(ArrayList<PlayerData> playerDataList) {
        this.playerDataList = playerDataList;
        JFrame frame = new JFrame("Fireball | Shield | Lute");
        JSplitPane sp = new JSplitPane();
        frame.add(sp);
        sp.setDividerLocation(300);

        // Creating a DefaultListModel and populating it with PlayerData
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (PlayerData playerData : playerDataList) {
            if (playerData.getIsActive()) {
                listModel.addElement(playerData.getFirstName() + " " + playerData.getLastName());
            }
        }

        // Creating JList and setting selection mode
        playerList = new JList<>(listModel);
        playerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Initializing JLabels for player information
        playerNameLabel = new JLabel("Player Name:");
        winRateLabel = new JLabel("Win Rate: ");

        // Creating the left panel with the player list and information labels
        lp = new JPanel(new BorderLayout());
        lp.add(new JScrollPane(playerList), BorderLayout.NORTH);

        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BorderLayout());
        labelsPanel.add(playerNameLabel, BorderLayout.NORTH);
        labelsPanel.add(winRateLabel, BorderLayout.CENTER);

        lp.add(labelsPanel, BorderLayout.SOUTH);
        add(lp, BorderLayout.WEST);

        // Handling player selection event
        playerList.addListSelectionListener(e -> {
            String selectedPlayer = playerList.getSelectedValue();
            if (selectedPlayer != null) {
                PlayerData selected = getPlayerByName(playerDataList, selectedPlayer);
                if (selected != null) {
                    playerNameLabel.setText("Player Name: " + selected.getFirstName());
                    winRateLabel.setText("Win Rate: " + selected.getWinRate() + "%");
                }
            }
        });
        
        

        
        luteBtn = new JButton("Lute"); //Text for button
        fireballBtn = new JButton("Fireball");
        shieldBtn = new JButton("Shield");
//----------------------------------------------------
        // Creating buttons for different actions
        luteBtn.setBounds(95, 20, 90, 40); // Set the bounds for the yellow button
        luteBtn.setBackground(Color.yellow); // Set the background color of the button to yellow
        luteBtn.addActionListener(this); // Add an action listener to the yellow button

        fireballBtn.setBounds(95, 70, 90, 40);
        fireballBtn.setBackground(Color.red);
        fireballBtn.addActionListener(this);
        
        // Handling button click events
        shieldBtn.setBounds(95, 120, 90, 40);
        shieldBtn.setBackground(Color.blue);
        shieldBtn.addActionListener(this);
 //---------------------------------------------------   
        
        // Creating the right panel and setting components
        rp = new JPanel(null);
        rp.add(luteBtn); //Puts button on right side
        rp.add(fireballBtn);
        rp.add(shieldBtn);
 //---------------------------------------------------    
        
        // Setting up the JFrame properties
        sp.setLeftComponent(lp);
        sp.setRightComponent(rp);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    }
    
    // ActionListener implementation for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (playerList.getSelectedValue() != null) {
            PlayerData selected = getPlayerByName(playerDataList, playerList.getSelectedValue());
            if (e.getSource() == fireballBtn) {
                // perform action for fireball btn
                System.out.println("testing");
            } else if (e.getSource() == shieldBtn) {
                // perform action for shieldBtn
            } else if (e.getSource() == luteBtn) {
                // Perform action for lute button
            }
        }
    }

    // Helper method to get player by name
    private PlayerData getPlayerByName(ArrayList<PlayerData> playerDataList, String name) {
        for (PlayerData player : playerDataList) {
            if (player.getIsActive() && (player.getFirstName() + " " + player.getLastName()).equals(name)) {
                return player;
            }
        }
        return null;
    }
}

    /*
    public ArrayList<PlayerData> getPlayerDataList() {
        return playerDataList;
    }

    public void setPlayerDataList(ArrayList<PlayerData> playerDataList) {
        this.playerDataList = playerDataList;
    }
    */