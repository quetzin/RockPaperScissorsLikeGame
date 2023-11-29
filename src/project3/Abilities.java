/**
 * The MagicCharacter class represents a character with magical abilities, 
 * extending the BaseCharacter class. It includes a reference to a 
 * FireballScroll.
 * 
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */
package project3;

public interface Abilities {

    static final int PERCENT = 100;     
    /**
    * @param hit The hit value to calculate damage based on.
    * @return The damage calculated as a percentage of the character's 
    * hit points.
    */
    int calculateDamage(int hit);       
                                        
    /**
     * Describes the graphical effects associated with the ability.
     * This method should provide a visual representation of the 
     * ability's effect.
     * @return 
     */
    String graphicalEffect();             
                                        
    /**
     * Describes the graphical effects associated with the failure or loss of a battle.
     * This method should provide a visual representation of the failure.
     * 
     * @return A string describing the graphical effects of failure.
     */
    String failureGraphic();     
    
}

