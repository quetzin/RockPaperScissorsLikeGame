package project3;

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
    }

}