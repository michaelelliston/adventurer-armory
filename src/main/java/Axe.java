public class Axe extends MeleeWeapon {

    private double typeFee;
    private String axeType;
    boolean isDoubleSided;

    public Axe(String type, String material, double basePrice, boolean isInlaid, String axeType, double typeFee) {
        super(type, material, basePrice, isInlaid);
        this.axeType = axeType;
        this.typeFee = typeFee;
    }
}
