/**
Braden Schlueter    plr61
Ibrahim Qafisheh    nmq6
Nicholas Rodriguez  dub7
Quetzin Pimentel    q_p12 
*/
package project2;

public abstract class BaseCharacter {
	
	private Object characterModel;
	public int hitPoints;
	public String armorType;
	
	public BaseCharacter(Object characterModel, int hitPoints, String armorType) {
	    this.characterModel = characterModel;
	    this.hitPoints = hitPoints;
	    this.armorType = armorType;
	}
	
	public Object getCharacterModel() {
		return characterModel;
	}

	public void setCharacterModel(Object characterModel) {
		this.characterModel = characterModel;
	}
	
	public abstract String getClassType(); 

}
