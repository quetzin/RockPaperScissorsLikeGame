package project3;

public class ShieldDefense implements Abilities {
    private int hitPoints;
    private int PERCENT = 150;
    
    public int calculateDamage(int hit) {
        return PERCENT - hit;
    }
    
    public void graphicalEffect() {
        System.out.println("The shield rebounds the attack.");
    }

    public void failureGraphic() {
        if (hitPoints <= 0) {
            System.out.println("Shield is dropped as the fighter falls asleep.");
        }
    }
}
