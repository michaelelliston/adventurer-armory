public class Sword extends MeleeWeapon {

    protected String swordType;

    public Sword(double basePrice, String material, boolean isInlaid, String gemType, String swordType) {
        super(basePrice, material, isInlaid, gemType);
        this.swordType = swordType;
    }

    public String getMaterial() {
        return this.material;
    }

    public String getType() {
        return this.swordType;
    }


    @Override
    public double getBasePrice() {

        return this.basePrice;
    }


}
