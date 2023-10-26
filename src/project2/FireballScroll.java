package project2;

public class FireballScroll implements Abilities{
	
	//private final int PERCENT = 100; Shouldnt need this now since 
    //  we added the Abilities implementation
	
	public int calculateDamage(int hit) {
		return PERCENT - hit;
	}
	
	// Braden - Added the graphical effect for Fireball Scroll per requiremnt doc
	public void graphicalEffect() {
		System.out.println("A large ball of flame hurtles toward the\n"
		        + "target.");
	}
}
