/**
Braden Schlueter    plr61
Ibrahim Qafisheh    nmq6
Nicholas Rodriguez  dub7
Quetzin Pimentel    q_p12 
*/

/**
 * The Abilities interface defines common functionality for character abilities.
 * Implementing classes should provide methods for calculating damage and describing graphical effects.
 * This interface is designed for character abilities in a role-playing game.
 *
 */
package project2;

public interface Abilities {
    static final int PERCENT = 100;     //Constant percent field set to 100.
                                        //  Represents characters total hitPoints.
    
    int calculateDamage(int hit);       //Represents the percent of a 
                                        //  character’s hitPoints to take.
    
    void graphicalEffect();             //Represents the visuals associated 
                                        //  with an ability.
    
}
