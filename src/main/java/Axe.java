public class Axe extends MeleeWeapon {

    protected String axeType;

    public Axe(double basePrice, String material, boolean isInlaid, String gemType, String axeType) {
        super(basePrice, material, isInlaid, gemType);
        this.axeType = axeType;
    }
}
