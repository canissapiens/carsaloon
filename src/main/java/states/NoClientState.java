package states;

import additives.ClientMenu;
import additives.MainMenu;
import controllers.MainController;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class NoClientState extends AbstractState {
    @Override
    public void showMenu(MainController mainController) {

        double y = 70;
        for (ClientMenu menu : ClientMenu.values()) {
            mainController.paneContainer.getChildren().add(mainController.screenObjects.getButton(
                    40, y, 120, menu.getDescription(),
                    e -> mainController.setValue(String.valueOf(menu.getMenuIdx()))));

            y += 40;
        }

        if (!mainController.client.getName().equals("") && mainController.client.getBudget() > 0) {
            mainController.paneContainer.getChildren().add(mainController.screenObjects.getButton(
                    40, y, 120, "Skonfiguruj samochód",
                    e -> mainController.setValue("S")));
        }
    }

    @Override
    public void setValue(MainController saloonController) {

        switch (saloonController.sentValue) {
            case "1":
                saloonController.setState(saloonController.setNameState);
                System.out.println("setNameState");
                break;

            case "2":
                // saloonController.s
                saloonController.setState(saloonController.setBudgetState);
                System.out.println("setBudgetState");
                break;

            case "S":
                saloonController.setState(saloonController.buildCarState);
                break;

            case "X":
                Platform.exit();
        }
    }
}
