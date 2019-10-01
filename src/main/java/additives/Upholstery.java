package additives;

public enum Upholstery {
    VELVET("Welur", 0, 1),
    SKIN("Skóra", 1000, 2),
    SUPERSKIN("Skóra pikowana", 2000, 3);

    private String description;
    private int price;
    private int menuIdx;

    Upholstery(String description, int price , int menuIdx) {
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
