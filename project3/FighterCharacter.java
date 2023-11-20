package project3;

public class FighterCharacter extends Object {
    
    private ShieldDefense shield;

        
    public ShieldDefense getFireballScroll() {
        return shield;
    }

    public FighterCharacter() {
        super(); // Call the constructor of the superclass Object
        shield = new ShieldDefense();
    }
}

