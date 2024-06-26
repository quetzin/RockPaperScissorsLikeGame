/**
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */
package project3;



import javax.xml.XMLConstants;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//----------------------------------------------------------------------------
/**
 * The Project3 class serves as the main class for a project involving XML data manipulation and a graphical user interface (GUI) for player interactions. It includes methods for parsing XML files, populating a list of PlayerData objects, constructing PlayerData objects from XML elements and user input, and updating an XML file with new player information.
 *
 * The class contains the main method that orchestrates the entire process. It reads an existing XML file, validates it against an XML schema, populates a list of player data, constructs a new PlayerData object from user input, adds the new player to the XML document, and finally updates the XML file.
 *
 * The GUI is initiated using the GraphicalUserInterface class, allowing users to interact with the player data visually.
 *
 */

public class Project3{

    public static void main(String[] args) {
        
       // ArrayList<PlayerData> playerList = new ArrayList<PlayerData>();
       // GraphicalUserInterface gui = new GraphicalUserInterface(playerList);
       // gui.setVisible(true);

        try {
            System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

            // Need to fix, its not accepting relative file path
            File xmlFile = new File("src/project3/players.xml");
            File xsdFile = new File("src/project3/players.xsd");
            
            if (!xmlFile.exists()) {
                throw new FileNotFoundException("XML file not found at the location specified");
            }
            
            if (!xsdFile.exists()) {
                throw new FileNotFoundException("XSD file not found at the location specified");
            }
           
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
            StreamResult result = new StreamResult("src/project3/Result.xmls");
            transformer.transform(src, result);
            
            GraphicalUserInterface gui = new GraphicalUserInterface(playerList);
            // gui.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
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
