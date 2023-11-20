package project3;

<<<<<<< HEAD
<<<<<<< HEAD
public class FighterCharacter extends BaseCharacter{

    private ShieldDefense defense;
    
    public FighterCharacter() {
        super(null, 150, "heavy");
    }
    
    public ShieldDefense getShieldDefense() {
        return defense;
    }


    public String getClassType() {
        // TODO Auto-generated method stub
        return null;
=======
public class FighterCharacter extends Object {
=======
import project2.BaseCharacter;

public class FighterCharacter extends BaseCharacter {
>>>>>>> 74235a9d2ca580fbc17cabeac3920ec178ad2f01
    
    private ShieldDefense shield;

        
    public ShieldDefense getFireballScroll() {
        return shield;
>>>>>>> f8db5a81b7c4b0f46efba843c1e24a6100de0773
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

