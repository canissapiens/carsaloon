package additives;

public enum Engine {
    GAS("Benzynowy", 0, 1),
    DIESEL("Diesel", 10000, 2),
    HYBRID("Hybryda", 15000, 3);

    private String description;
    private int price;
    private int menuIdx;

    Engine(String description, int price, int menuIdx) {
        this.description = description;
        this.price = price;
        this.menuIdx = menuIdx;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getMenuIdx() {
        return menuIdx;
    }
}
