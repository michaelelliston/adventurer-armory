public class Sword extends MeleeWeapon {

    private double typeFee;
    private String swordType;

    public Sword(String type, String material, double basePrice, boolean isInlaid, String swordType, double typeFee) {
        super(type, material, basePrice, isInlaid);
        this.swordType = swordType;
        this.typeFee = typeFee;
    }

    @Override
    public double getPrice() {

        return 0;
    }


}
