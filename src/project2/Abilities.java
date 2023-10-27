/**
* @author Braden Schlueter (plr61)
* @author Ibrahim Qafisheh (nmq6)
* @author Nicholas Rodriguez (dub7)
* @author Quetzin Pimentel (q_p12)
*/
package project2;

public interface Abilities {

    static final int PERCENT = 100;     
    /**
    * @param hit The hit value to calculate damage based on.
    * @return The damage calculated as a percentage of the character's hit points.
    */
    int calculateDamage(int hit);       //Represents the percent of a 
                                        //  character’s hitPoints to take.
    
    void graphicalEffect();             //Represents the visuals associated 
                                        //  with an ability.
}
