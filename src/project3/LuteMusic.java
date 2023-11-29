/**
 * The LuteMusic class represents the abilities related to playing music with a lute in a game.
 * It implements the Abilities interface.
 * 
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */

package project3;

public class LuteMusic implements Abilities{
    
    /**
     * Calculates the damage based on the hit value.
     *
     * @param hit the hit value.
     * @return the calculated damage.
     */
    public int calculateDamage(int hit) {
        return PERCENT - hit;
    }
    
    /**
     * Displays a graphical effect when the lute music is played.
     */
    public void graphicalEffect() {
        System.out.println("The lullaby makes the combatant sleepy.");
    }
    
    /**
     * Displays a graphical representation of a failure when playing the lute.
     * This method prints a message to the console indicating the failure scenario.
     */
    public void failureGraphic() {
        System.out.println("Lute is engulfed in flames");
    }

}