package project3;

public class FighterCharacter {
    private static final int PERCENT = 100;

    public int calculateDamage(int hit) {
        return PERCENT - hit;

        }
        
        
        public void graphicalEffect() {
            System.out.println("The shield rebounds the attack.");
        }
    }

