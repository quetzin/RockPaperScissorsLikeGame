package project3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.Math;
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
    
    private FireballScroll fireballScroll;
    private LuteMusic luteMusic;
    private ShieldDefense shieldDefense;
    
    JLabel resultLabel = new JLabel();
    
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
        
        fireballScroll = new FireballScroll();
        luteMusic = new LuteMusic();
        shieldDefense = new ShieldDefense();

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
                luteBtn.setVisible(true);
                fireballBtn.setVisible(true);
                shieldBtn.setVisible(true);
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
        luteBtn.setVisible(false);
        fireballBtn.setVisible(false);
        shieldBtn.setVisible(false);
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
        
        
        resultLabel.setBounds(95, 170, 200, 40);
        rp.add(resultLabel);
        
        
        // Setting up the JFrame properties
        sp.setLeftComponent(lp);
        sp.setRightComponent(rp);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (playerList.getSelectedValue() != null) {
            PlayerData selected = getPlayerByName(playerDataList, playerList.getSelectedValue());
            String result = null;
            if (e.getSource() == fireballBtn) {
                // perform action for fireball btn
                result = playFireball(selected);
            } else if (e.getSource() == shieldBtn) {
                result = playShieldDefense(selected);
            } else if (e.getSource() == luteBtn) {
                result = playLuteMusic(selected);
            }
            resultLabel.setText(result);
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
    
    private String playFireball(PlayerData playerDataList) {
        int opponentClass = getRandomOpponent(); // Implement this method to get a random opponent class
        if (opponentClass == 1) {
             return fireballScroll.failureGraphic();
        } else if (opponentClass == 2) {
             return fireballScroll.graphicalEffect();
        } else {
             return "It's a draw.";
        }
    }
    
    private String playShieldDefense(PlayerData playerDataList) {
        int opponentClass = getRandomOpponent();
        if (opponentClass == 1) {
             return shieldDefense.failureGraphic();
        } else if (opponentClass == 2) {
             return shieldDefense.graphicalEffect();
        } else {
             return "It's a draw.";
        }
    }
    
    private String playLuteMusic(PlayerData playerDataList) {
        int opponentClass = getRandomOpponent();
        if (opponentClass == 1) {
             return luteMusic.failureGraphic();
        } else if (opponentClass == 2) {
             return luteMusic.graphicalEffect();
        } else {
            return "It's a draw.";
        }
    }
    
    private int getRandomOpponent() {
        return (int) (Math.random() * 3) + 1;
    }
}

