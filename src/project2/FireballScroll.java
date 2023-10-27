package project2;

public class FireballScroll implements Abilities{
	
	
	public int calculateDamage(int hit) {
		return PERCENT - hit;
	}
	

	public void graphicalEffect() {
		System.out.println("A large ball of flame hurtles toward the\n"
		        + "target.");
	}
}
