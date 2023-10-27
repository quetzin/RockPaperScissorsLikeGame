/**
Braden Schlueter    plr61
Ibrahim Qafisheh    nmq6
Nicholas Rodriguez  dub7
Quetzin Pimentel    q_p12 
*/
package project2;

public class FireballScroll implements Abilities{
	
	
	public int calculateDamage(int hit) {
		return PERCENT - hit;
	}
	

	public void graphicalEffect() {
		System.out.println("A large ball of flame hurtles toward thetarget.");
	}
}
