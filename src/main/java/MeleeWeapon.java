public abstract class MeleeWeapon extends Weapon {
    // TODO: Create fields for MeleeWeapon
    protected String gemType = "None";
    protected boolean isInlaid;

    public MeleeWeapon(double basePrice, String material,boolean isInlaid, String gemType) {
        super(basePrice, material);
        this.isInlaid = isInlaid;
        this.gemType = gemType;
    }

    public String getGemType() {
        return this.gemType;
    }
}
