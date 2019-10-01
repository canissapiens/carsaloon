package states;

import controllers.MainController;
import javafx.application.Platform;

public class SetNameState extends AbstractState {

    @Override
    public void showMenu(MainController saloonController) {

        saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getLabel(
                40, 40, "Podaj imię:"
        ));
        String name;
        saloonController.textField = saloonController.screenObjects.getTextField(
                40, 80, 160, 30, "input", saloonController.client.getName());
        saloonController.paneContainer.getChildren().add(saloonController.textField);

        saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getButton(
                40, 120, 120, "Zapisz",
                e -> saloonController.setValue(String.valueOf(1))));
    }

    @Override
    public void setValue(MainController saloonController) {
        switch (saloonController.sentValue) {
            case "1":
                System.out.println(saloonController.textField.getText());
                saloonController.client.setName(saloonController.textField.getText());
                saloonController.setState(saloonController.noClientState);
                break;
            case "X":
                Platform.exit();
        }

    }
}