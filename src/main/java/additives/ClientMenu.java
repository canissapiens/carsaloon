package additives;

import controllers.MainController.*;

public enum ClientMenu {
    NAME("Podaj imię", 1),
    BUDGET("Podaj budżet", 2);

    private String description;
    private int menuIdx;


    ClientMenu(String description, int menuIdx) {
        this.description = description;
        this.menuIdx = menuIdx;
    }

    public String getDescription() {
        return description;
    }

    public int getMenuIdx() {
        return menuIdx;
    }

    @FunctionalInterface
    interface GetInt {
        int result(int n);
    }
}
