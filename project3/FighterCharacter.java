package project3;

// import project2.BaseCharacter;
// Shouldn't need this as the BaseCharacter extends should cover such -Braden

public class FighterCharacter extends BaseCharacter {

    
    private ShieldDefense shield;

    
    // Known bugs with this, in main its using 100 hp instead of 150 hp. If you run the file you should see it in the output

    public FighterCharacter() {
        //super(null, 150, "heavy");
        // Call the constructor of the superclass Object
        hitPoints = 150;
        armorType = "heavy";
        shield = new ShieldDefense();
    }
    
    public ShieldDefense getShieldDefense() {
        return shield;
    }
    
    @Override
    public String getClassType() {
        return "Fighter";
    }
}

