package additives;

public enum Body {
    SEDAN("Sedan", 0, 1),
    COMBI("Combi", 1000, 2),
    HATCHBACK("Hatchback", 1000, 3),
    PICKUP("Pick-Up", 2000, 4);

    private String description;
    private int price;
    private int menuIdx;

    Body(String description, int price, int menuIdx) {
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
