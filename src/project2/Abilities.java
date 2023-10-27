/**
Braden Schlueter    plr61
Ibrahim Qafisheh    nmq6
Nicholas Rodriguez  dub7
Quetzin Pimentel    q_p12 
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
