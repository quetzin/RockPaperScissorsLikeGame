/**
Braden Schlueter    plr61
Ibrahim Qafisheh    nmq6
Nicholas Rodriguez  dub7
Quetzin Pimentel    q_p12 
*/
package project2;

// FireballScroll class provides calculates the damage percentage
// caused by the fireball and display the graphical effects
// of the fireball when hitting the target
public class FireballScroll implements Abilities{
	
	// calculateDamage function calculate the damage of the fireball
	// and return the value
	public int calculateDamage(int hit) {
		return PERCENT - hit;
	}
	
	// graphicalEffect function displays the graphical effects for 
	// the ball hitting the target
	public void graphicalEffect() {
		System.out.println("A large ball of flame hurtles toward the target.");
	}
}
