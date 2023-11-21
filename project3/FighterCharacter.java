package project3;

// import project2.BaseCharacter;
// Shouldn't need this as the BaseCharacter extends should cover such -Braden

public class FighterCharacter extends BaseCharacter {

    
    private ShieldDefense shield;

        
    public ShieldDefense getShieldDefense() {
        return shield;
    }

    public FighterCharacter() {
<<<<<<< HEAD
        
        super(null, 150, "heavy");// Call the constructor of the superclass Object
=======
        super(null, 150, "heavy");
        // Call the constructor of the superclass Object
>>>>>>> c53d70321933ec2e5671b283fc46a0bd69a5ccd2
        shield = new ShieldDefense();
    }
    @Override
    public String getClassType() {
        return "Fighter";
    }
}

