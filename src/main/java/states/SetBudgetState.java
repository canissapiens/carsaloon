package states;

import controllers.MainController;
import javafx.application.Platform;

public class SetBudgetState extends AbstractState {


    @Override
    public void showMenu(MainController saloonController) {

        saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getLabel(
                40, 32, "Określ budżet:"
        ));

        String budget;
        if (saloonController.client.getBudget() == 0) {
            budget = "";
        } else {
            budget = String.valueOf(saloonController.client.getBudget());
        }
        saloonController.textField = saloonController.screenObjects.getTextField(
                40, 80, 160, 30, "input", budget);
        saloonController.paneContainer.getChildren().add(saloonController.textField);

        saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getButton(
                40, 120, 120, "Zapisz",
                e -> saloonController.setValue("1")));
    }

    @Override
    public void setValue(MainController saloonController) {
        switch (saloonController.sentValue) {
            case "1":
                System.out.println(saloonController.textField.getText());

                try {
                    int budget = (int) Integer.valueOf(saloonController.textField.getText());
                    saloonController.client.setBudget(budget);
                    saloonController.setState(saloonController.noClientState);
                } catch (Exception e) {
                    saloonController.badStatement = "Błędna kwota";
                }
                break;

            case "X":
                Platform.exit();
        }
    }
}