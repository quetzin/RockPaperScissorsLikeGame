/**
 * The BaseCharacter class represents the common attributes and methods 
 * shared by character types in a role-playing game.
 *
 * @author Braden Schlueter    plr61
 * @author Ibrahim Qafisheh    nmq6
 * @author Nicholas Rodriguez  dub7
 * @author Quetzin Pimentel    q_p12
 */
package project3;

public abstract class BaseCharacter {
	
	private Object characterModel;		//Private Object field to represent 
	                                        //the character model.
	public int hitPoints;				//Public int field to represent the 
	                                        //character’s hitPoints.
	public String armorType;			//Public String field to represent 
	                                        //the character’s armorType.
	
	/**
     * Constructs a BaseCharacter object with the provided character model, 
     * hitPoints, and armorType.
     *
     * @param characterModel The object representing the character model.
     * @param hitPoints      The hit points of the character.
     * @param armorType      The type of armor the character uses.
     */
	public BaseCharacter(Object characterModel, int hitPoints, String armorType) {	
	    this.characterModel = characterModel;	 //Sets the character model.
	    this.hitPoints = hitPoints;			     //Sets the hitPoints.
	    this.armorType = armorType;			     //Sets the armorType.
	}	
	
	/**
     * Gets the character model associated with the character.
     *
     * @return The character model.
     */
	public Object getCharacterModel() {	//Getter for the character model.
		return characterModel;
	}
	
	/**
     * Sets the character model for the character.
     *
     * @param characterModel The object representing the character model.
     */
	public void setCharacterModel(Object characterModel) {     //Setter for the 
		this.characterModel = characterModel;                  //character model.
	}
	
	/**
     * Returns the type of the character's class.
     *
     * @return A string representing the class type.
     */
	public abstract String getClassType(); 		//Abstract method to return
	                                            //the class type.

}
