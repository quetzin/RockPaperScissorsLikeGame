/**
 * The ShieldDefense class represents the abilities related to using a shield for defense in a game.
 * It implements the Abilities interface.
 * 
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */

package project3;

public class ShieldDefense implements Abilities {
    //private int hitPoints;
    private int PERCENT = 150;
    
    /**
     * The percentage value representing the effectiveness of the shield defense.
     */
    public int calculateDamage(int hit) {
        return PERCENT - hit;
    }
    
    /**
     * Calculates the damage reduction based on the hit value.
     *
     * @param hit the hit value.
     * @return the calculated damage reduction.
     */
    public String graphicalEffect() {
        return "The shield rebounds the attack.";
    }
    
    /**
     * Displays a graphical effect when the shield successfully rebounds an attack.
     */
    public String failureGraphic() {
        //if (hitPoints <= 0) {
            //return "Shield is dropped as the fighter falls asleep.";
       // }
    	return "Shield is dropped as the fighter falls asleep.";
    }
}
