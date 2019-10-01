package additives;

public enum Color {
    RED("Czerwony", 2000, 1),
    BLUE("Niebieski", 0, 2),
    YELLOW("Żółty", 4000, 3);

    private String description;
    private int price;
    private int menuIdx;

    Color(String description, int price, int menuIdx) {
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
