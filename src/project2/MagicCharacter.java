/**
Braden Schlueter    plr61
Ibrahim Qafisheh    nmq6
Nicholas Rodriguez  dub7
Quetzin Pimentel    q_p12 
*/
package project2;

public class MagicCharacter extends BaseCharacter{
	
	private FireballScroll fireball;
	
	public FireballScroll getFireballScroll() {
		return fireball;
	}
	
	public MagicCharacter() {
		// hitPoints = 70;
		// armorType = "light";
	    super(null, 70, "light");
		fireball = new FireballScroll();
	}

	
    @Override
    public String getClassType() {
        return "Magic";
    }
	
}
