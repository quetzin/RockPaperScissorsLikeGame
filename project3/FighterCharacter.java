package project3;

import project2.BaseCharacter;

public class FighterCharacter extends BaseCharacter {

    
    private ShieldDefense shield;

        
    public ShieldDefense getFireballScroll() {
        return shield;
    }

    public FighterCharacter() {
        super(null, 150, "heavy");// Call the constructor of the superclass Object
        shield = new ShieldDefense();
    }
    
    @Override
    public String getClassType() {
        return "Fighter";
    }
}

