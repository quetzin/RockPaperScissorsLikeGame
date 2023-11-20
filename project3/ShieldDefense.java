package project3;

public class ShieldDefense implements Abilities {

    public int calculateDamage(int hit) {
        return PERCENT - hit;
    }
    
    
    public void graphicalEffect() {
        System.out.println("The shield rebounds the attack.");
    }

}