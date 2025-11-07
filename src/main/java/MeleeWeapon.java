public abstract class MeleeWeapon extends Weapon {
    // TODO: Create fields for MeleeWeapon
    private boolean isInlaid;

    public MeleeWeapon(String type, String material, double basePrice, boolean isInlaid) {
        super(type, material, basePrice);
        this.isInlaid = isInlaid;
    }
}
