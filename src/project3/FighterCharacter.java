/**
 * The FighterCharacter class represents a character of type "Fighter" in a game.
 * It extends the BaseCharacter class and has additional features related to the fighter class,
 * including a shield for defense.
 * 
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */

package project3;

public class FighterCharacter extends BaseCharacter {

    private ShieldDefense shield;
    
    /**
     * Constructs a new FighterCharacter with default hit points, armor type, and a shield.
     */
    public FighterCharacter() {
        hitPoints = 150;
        armorType = "heavy";
        shield = new ShieldDefense();
    }
    
    /**
     * Gets the shield associated with this fighter character.
     *
     * @return the shield defense object.
     */
    public ShieldDefense getShieldDefense() {
        return shield;
    }
    
    /**
     * Overrides the method in the base class to return the specific class type, which is "Fighter".
     *
     * @return the class type, which is "Fighter".
     */
    @Override
    public String getClassType() {
        return "Fighter";
    }
}

