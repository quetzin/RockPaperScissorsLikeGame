package project3;

import project2.BaseCharacter;

public class FighterCharacter extends BaseCharacter {

    
    private ShieldDefense shield;

        
    public ShieldDefense getShieldDefense() {
        return shield;
    }

    public FighterCharacter() {
        super(null, 150, "heavy");
        // Call the constructor of the superclass Object
        shield = new ShieldDefense();
    }
<<<<<<< HEAD

=======
    
>>>>>>> 59092dc51fe1dde628f277ae6175aac0d8f4f42d
    @Override
    public String getClassType() {
        return "Fighter";
    }
}

