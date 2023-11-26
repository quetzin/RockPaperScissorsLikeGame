/**
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */
package project3;

import java.util.UUID;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalDateTime;
import org.w3c.dom.NodeList;

import project3.GraphicalUserInterface;

import org.w3c.dom.Node;  
import org.w3c.dom.Element; 
import javax.swing.JButton;
import javax.swing.JFrame;



/**
 * Project 2: Game Character Inheritance
 * 1. In this project we use inheritance to implement a character
 *      and run operations on the specific character's abilities
 */
public class Project3 {
   
    public static void main(String[] args) {
        // try/catch statement that makes sure that all inputs have been 
        //provided and they are in the correct type
        try {
            
            MagicCharacter mage = new MagicCharacter();
        	System.out.println("Mage hitpoints = " + mage.hitPoints);
        	System.out.println("Fireball hit! " + mage.getFireballScroll().calculateDamage(20));
        	mage.getFireballScroll().graphicalEffect();
        	System.out.println();

        	
        	// Testing for fighter character - Remove later -Braden
        	FighterCharacter rocky = new FighterCharacter();
        	System.out.println("Rocky hitpoints = " + rocky.hitPoints);
        	System.out.println("Shield testing! " + rocky.getShieldDefense().calculateDamage(70));
        	rocky.getShieldDefense().graphicalEffect();
        	System.out.println();
            
        	// Testing for Bard character - Remove later -Braden
        	BardCharacter bard = new BardCharacter();
        	System.out.println("Bard htipoints = " + bard.hitPoints);
        	System.out.println("Lute testing! " + bard.getLuteMusic().calculateDamage(40));
        	bard.getLuteMusic().graphicalEffect();
     
        	// Gui is opening and title is correct
        	JFrame frame = new GraphicalUserInterface();
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setTitle("Fireball | Shield | Lute");
        	frame.setVisible(true);
        	
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input type");
        }  
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not all inputs have been provided");
        }
            
        
    }
    
    /**
     * Populates a list of PlayerData objects from a NodeList of XML data.
     *
     * @param nodeList A NodeList containing XML data representing 
     * player information.
     * @return An ArrayList of PlayerData objects extracted from 
     * the XML data.
     */
    public static ArrayList<PlayerData> populatePlayerList(NodeList nodeList) {
        ArrayList<PlayerData> playerList = new ArrayList<PlayerData>();
        
        //loop through the list of nodes
        for(int i = 0; i < nodeList.getLength(); i++) {
            //1. Get node
            Node node = nodeList.item(i);
            
            //2. If node is the correct type, extract the player data.
            if(node.getNodeType() == Node.ELEMENT_NODE) { 
                
                //3. playerElement is created from node.
                Element playerElement = (Element) node;
                
                //4. Construct a PlayerData object from the XML player data.
                PlayerData player = constructPlayerFromElement(playerElement);
                
                //TODO - Add player to the playerList
                playerList.add(player);
            }
        }
        return playerList;
    }
    
    /**
     * 
     * @param player contains player data
     * @return the data in its correct data type
     */
    public static PlayerData constructPlayerFromElement(Element player) {
        
        
        UUID guid = UUID.fromString(player.getElementsByTagName("guid").item(0).getTextContent());
        boolean isActive = Boolean.parseBoolean(player.getElementsByTagName("isActive").item(0).getTextContent());
        String firstName = String.valueOf(player.getElementsByTagName("firstName").item(0).getTextContent());
        String lastName = String.valueOf(player.getElementsByTagName("lastName").item(0).getTextContent());
        String email = String.valueOf(player.getElementsByTagName("email").item(0).getTextContent());
        int rank = Integer.parseInt(player.getElementsByTagName("rank").item(0).getTextContent());
        int winRate = Integer.parseInt(player.getElementsByTagName("winRate").item(0).getTextContent());
        LocalDateTime registered = LocalDateTime.parse(player.getElementsByTagName("registered").item(0).getTextContent());
        LocalDateTime lastPlayed = LocalDateTime.parse(player.getElementsByTagName("lastPlayed").item(0).getTextContent());

  
        PlayerData newPlayer = new PlayerData(guid, isActive, firstName, lastName, email, rank, winRate, registered, lastPlayed);
   
        
        return newPlayer;
    }
    
    /**
     * TODO - Populate all of the TODOs in this method
     * @param input user input that contains player information
     * @return the data of the player in a PlayerData element
     */
    public static PlayerData constructPlayerFromInput(String[] input) {
        
       
        UUID guid = UUID.fromString(input[0]);
        boolean isActive = Boolean.valueOf(input[1]);
        String firstName = String.valueOf(input[2]);
        String lastName = String.valueOf(input[3]);
        String email = String.valueOf(input[4]);
        int rank = Integer.parseInt(input[5]);
        int winRate = Integer.parseInt(input[6]);
        LocalDateTime registered = LocalDateTime.parse(input[7]);
        LocalDateTime lastPlayed = LocalDateTime.parse(input[8]);

        
        PlayerData newPlayer = new PlayerData(guid, isActive, firstName, lastName, email, rank, winRate, registered, lastPlayed);
        
        return newPlayer;
    }
    
    //Creates an instance of the GraphicalUserInterface fireball button:
    GraphicalUserInterface FireballButton = new GraphicalUserInterface();

    
}
