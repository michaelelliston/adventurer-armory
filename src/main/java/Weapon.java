public abstract class Weapon implements Priceable {

    private String type;
    private String material;
    private double basePrice;

    public Weapon(String type, String material, double basePrice) {
        this.type = type;
        this.material = material;
        this.basePrice = basePrice;
    }

    @Override
    public double getPrice() {
        return this.basePrice;
    }
}
