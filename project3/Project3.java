/**
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */
package project3;

import project1.PlayerData;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;  
import org.xml.sax.SAXException;
import org.w3c.dom.Node;  
import org.w3c.dom.Element; 

import java.util.UUID;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//----------------------------------------------------------------------------

/**
 * Project 2: Game Character Inheritance
 * 1. In this project we use inheritance to implement a character
 *      and run operations on the specific character's abilities
 */
public class Project3 extends GraphicalUserInterface{

    public static void main(String[] args) {
        
      //Code from project1 main():
      //TODO - the args should be populated with the field data for a new PlayerData object.
        try {
            //TODO - Finish the file path names
            File xmlFile = new File("src/project1/data.xml");
            File xsdFile = new File("src/project1/data.xsd");
            
            //TODO - Create a ArrayList of PlayerData called "playerList"
            ArrayList<PlayerData> playerList = new ArrayList<PlayerData>();
            
            //XML parsing
            Document parsedXML = readXML(xmlFile, xsdFile);
            
            //Accessing XML player data via nodeList
            Element root = parsedXML.getDocumentElement();
            NodeList nodeList = parsedXML.getElementsByTagName("Player");
            
            //Store player's data in playerList.
            playerList = populatePlayerList(nodeList);
            
            //TODO - Call constructPlayerFromInput() to create a PlayerData object from the input info.         
            PlayerData newPlayer = constructPlayerFromInput(args);
           
            
            //TODO - Call addToXML() to add the new player to the Result.xml document.
            addToXML(newPlayer, parsedXML);
            
            DOMSource src = new DOMSource(parsedXML);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("src/project1/Result.xml");
            transformer.transform(src, result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
//----------------------------------------------------------------------------
        
        new GraphicalUserInterface(); //Calls new gui 
    
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
        
            
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input type");
        }  
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not all inputs have been provided");
        }       
    }
//----------------------------------------------------------------------------
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
    
//----------------------------------------------------------------------------
    /**
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
//----------------------------------------------------------------------------
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
//----------------------------------------------------------------------------
    /**
     * readXML():
     * Do not modify this method!
     * @param xmlFile
     * @param xsdFile
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static Document readXML(File xmlFile, File xsdFile) throws ParserConfigurationException, SAXException, IOException{

        //Setting up Factory and Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Schema schema = null;
        
        //Parsing xml document
        Document parsedXML = builder.parse(xmlFile);
        parsedXML.getDocumentElement().normalize();
        
        //Setting up schema
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(lang);
        schema = schemaFactory.newSchema(xsdFile);
        
        //Validating schema
        Validator validator = schema.newValidator();
        validator.validate(new DOMSource(parsedXML));
        
        return parsedXML;
    }
//----------------------------------------------------------------------------
    /**
     * addToXML():
     * Do not change this method!
     * @param player
     * @param parsedXML
     */
    public static void addToXML(PlayerData player, Document parsedXML) {
        Element root = parsedXML.getDocumentElement();
        Element newPlayer = parsedXML.createElement("Player");
        
        Element guid = parsedXML.createElement("guid");
        guid.appendChild(parsedXML.createTextNode(player.getGUID().toString()));
        Element isActive = parsedXML.createElement("isActive");
        isActive.appendChild(parsedXML.createTextNode(player.getIsActive() == true ? "true" : "false"));
        Element firstName = parsedXML.createElement("firstName");
        firstName.appendChild(parsedXML.createTextNode(player.getFirstName().toString()));
        Element lastName = parsedXML.createElement("lastName");
        lastName.appendChild(parsedXML.createTextNode(player.getLastName().toString()));
        Element email = parsedXML.createElement("email");
        email.appendChild(parsedXML.createTextNode(player.getEmail().toString()));
        Element rank = parsedXML.createElement("rank");
        rank.appendChild(parsedXML.createTextNode("" + player.getRank()));
        Element winRate = parsedXML.createElement("winRate");
        winRate.appendChild(parsedXML.createTextNode("" + player.getWinRate()));
        Element registered = parsedXML.createElement("registered");
        registered.appendChild(parsedXML.createTextNode(player.getRegistered().toString()));
        Element lastPlayed = parsedXML.createElement("LastPlayed");
        lastPlayed.appendChild(parsedXML.createTextNode(player.getLastPlayed().toString()));
        
        newPlayer.appendChild(guid);
        newPlayer.appendChild(isActive);
        newPlayer.appendChild(firstName);
        newPlayer.appendChild(lastName);
        newPlayer.appendChild(email);
        newPlayer.appendChild(rank);
        newPlayer.appendChild(winRate);
        newPlayer.appendChild(registered);
        newPlayer.appendChild(lastPlayed);
        
        //Do not change this.
        root.appendChild(newPlayer);

    }
}
