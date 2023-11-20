package project3;

public class ShieldDefense implements Abilities {
    private int hitPoints;

    public int calculateDamage(int hit) {
        return PERCENT - hit;
    }
    
    public void graphicalEffect() {
        System.out.println("The shield rebounds the attack.");
    }

    public void loseBattle() {
        if (hitPoints <= 0) {
            System.out.println("You have lost the battle.");
        }
    }
}
