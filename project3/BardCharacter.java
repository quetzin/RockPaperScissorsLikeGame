package project3;

public class BardCharacter extends BaseCharacter {

    public int calculateDamage(int hit) {
        return PERCENT - hit;
    }
    
    
    public void graphicalEffect() {
        System.out.println("The lullaby makes the combatant sleepy.");
    }

}