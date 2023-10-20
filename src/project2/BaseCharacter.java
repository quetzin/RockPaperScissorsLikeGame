package project2;

public abstract class BaseCharacter {
	
	private Object characterModel;
	public int hitPoints;
	public String armorType;
	
	public Object getCharacterModel() {
		return characterModel;
	}

	public void setCharacterModel(Object characterModel) {
		this.characterModel = characterModel;
	}
	
	public abstract String getClassType(); 

}
