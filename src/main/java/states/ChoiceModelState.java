package states;

import additives.Model;
import controllers.MainController;

public class ChoiceModelState extends AbstractState {
    @Override
    public void showMenu(MainController saloonController) {

        double y = 70;
        for (Model menu : Model.values()) {
            saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getButton(
                    40, y, 120, menu.getDescription(),
                    e -> saloonController.setValue(String.valueOf(menu.getMenuIdx()))));

            saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getLabel(
                    200, y + 4, String.valueOf(menu.getPrice())
            ));

            y += 40;
        }
        saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getButton(
                40, 300, 120, "Powrót",
                e -> saloonController.setValue("U")));
    }

    @Override
    public void setValue(MainController saloonController) {
        if (saloonController.sentValue.equals("U")) {
            saloonController.setState(saloonController.buildCarState);
        } else {
            int selection = 0;
            try {
                selection = Integer.valueOf(saloonController.sentValue);
                int i = 1;
                Model selectedModel = null;
                for (Model model : Model.values()) {
                    if (model.getMenuIdx() == selection) {
                        selectedModel = model;
                        System.out.println("Wybrano " + i);
                        break;
                    }
                }
                System.out.println(selectedModel.getDescription());

                if (saloonController.client.getBudget() >=
                        (selectedModel.getPrice() + saloonController.carBuilder.getPriceWithoutModel())) {
                    saloonController.carBuilder.setModel(selectedModel);
                    saloonController.setState(saloonController.buildCarState);
                } else {
                    saloonController.badStatement = "Za biednyś";
                    saloonController.badChoice++;
                }

            } catch (Exception e) {
                saloonController.badStatement = "Błędny wybór";
            }
        }
    }
}


