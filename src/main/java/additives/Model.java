package additives;

public enum Model {
    FIAT("Fiat", 40000, 1),
    CITROEN("Citroen", 50000, 2),
    KIA("Kia", 30000, 3);

    private String description;
    private int price;
    private int menuIdx;

    Model(String description, int price, int menuIdx) {
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
