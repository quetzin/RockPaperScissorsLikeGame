/**
 * The FireballScroll class provides the ability to calculate the damage 
 * percentage caused by a fireball and display the graphical effects of 
 * the fireball when hitting the target. This class implements the 
 * Abilities interface for character abilities.
 *
 * @author Braden Schlueter    plr61
 * @author Ibrahim Qafisheh    nmq6
 * @author Nicholas Rodriguez  dub7
 * @author Quetzin Pimentel    q_p12
 */
package project3;

// FireballScroll class provides calculates the damage percentage
// caused by the fireball and display the graphical effects
// of the fireball when hitting the target
public class FireballScroll implements Abilities{
	
    /**
     * Calculates the damage inflicted by the fireball.
     *
     * @param hit The amount of hit points to be subtracted.
     * @return The percentage of a character's hit points to take as damage.
     */
	public int calculateDamage(int hit) {
		return PERCENT - hit;
	}
	
	/**
     * Displays the graphical effects associated with a fireball hitting 
     * the target.
     */
	public void graphicalEffect() {
		System.out.println("A large ball of flame hurtles toward the target.");
	}
	
	/**
	 * Displays a graphic representation of a failure when a fireball spell rebounds into the mage's scroll.
	 * This method prints a message to the console indicating the failure scenario.
	 */
	public void failureGraphic() {
	    System.out.println("Fireball rebounds into the mage’s scroll!");
	}
}
