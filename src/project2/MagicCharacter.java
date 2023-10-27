/**
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */
package project2;

public class MagicCharacter extends BaseCharacter{
    
    private FireballScroll fireball;
    
    public FireballScroll getFireballScroll() {
        return fireball;
    }
    
    /**
    * Construct a MagicCharacter object. Initializes the character with no
    * name, 70 hit points, and a "light" alignment. It also creates a 
    * FireballScroll for the character.
    */
    public MagicCharacter() {
        super(null, 70, "light");
        fireball = new FireballScroll();
    }

    /**
     * Get the class type of this character, which is "Magic."
     *
     * @return The class type of the character.
     */
     @Override
    public String getClassType() {
        return "Magic";
    }
    
}
