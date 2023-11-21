package project3;

public class BardCharacter extends BaseCharacter {

    private LuteMusic lute;
    
    public BardCharacter() {
       // super(null, 100, "medium");
        hitPoints = 100;
        armorType = "medium";
        lute = new LuteMusic();
    }
    
    public LuteMusic getLuteMusic() {
        return lute;
    }


    @Override
    public String getClassType() {
        return "Bard";
    }

}