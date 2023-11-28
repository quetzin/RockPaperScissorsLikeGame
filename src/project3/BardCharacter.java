/**
 * The BardCharacter class represents a character of type "Bard" in a game.
 * It extends the BaseCharacter class and has additional features related to the bard class,
 * including a lute for playing music.
 * 
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */
package project3;

public class BardCharacter extends BaseCharacter {

    private LuteMusic lute;
    
    /**
     * Constructs a new {@code BardCharacter} with default hit points, armor type, and a lute.
     */
    public BardCharacter() {
        hitPoints = 100;
        armorType = "medium";
        lute = new LuteMusic();
    }
    
    /**
     * Gets the lute associated with this bard character.
     *
     * @return the lute music object.
     */
    public LuteMusic getLuteMusic() {
        return lute;
    }

    /**
     * Overrides the method in the base class to return the specific class type, which is "Bard".
     *
     * @return the class type, which is "Bard".
     */
    @Override
    public String getClassType() {
        return "Bard";
    }

}