/**
Braden Schlueter    plr61
Ibrahim Qafisheh    nmq6
Nicholas Rodriguez  dub7
Quetzin Pimentel    q_p12 
*/
package project2;

public abstract class BaseCharacter {
	
	private Object characterModel;		//Private Object field to represent the character model.
	public int hitPoints;				//Public int field to represent the character’s hitPoints.
	public String armorType;			//Public String field to represent the character’s armorType.
	
	public BaseCharacter(Object characterModel, int hitPoints, String armorType) {	//Constructor for the BaseCharacter class.
	    this.characterModel = characterModel;	//Sets the character model.
	    this.hitPoints = hitPoints;			//Sets the hitPoints.
	    this.armorType = armorType;			//Sets the armorType.
	}	
	
	public Object getCharacterModel() {	//Getter for the character model.
		return characterModel;
	}

	public void setCharacterModel(Object characterModel) {	//Setter for the character model.
		this.characterModel = characterModel;
	}
	
	public abstract String getClassType(); 		//Abstract method to return the class type.

}
