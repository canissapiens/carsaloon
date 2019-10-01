package additives;

import java.util.function.Predicate;

public enum MainMenu {
    MODEL("Select model", 1),
    BODY("Select body", 2),
    ENGINE("Select engine type", 3),
    COLOR("Select color", 4),
    UPHOLSTERY("Select upholstery", 5);

    private String description;
    private int menuIdx;

    // MainMenu(String description, Predicate<Integer> command) {
    MainMenu(String description, int menuIdx) {
        this.description = description;
        this.menuIdx = menuIdx;
        // this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public int getMenuIdx() {
        return menuIdx;
    }
}
