package states;

import additives.Engine;
import additives.Model;
import controllers.MainController;

public class ChoiceEngineState extends AbstractState {
    @Override
    public void showMenu(MainController saloonController) {
        double y = 70;
        for (Engine menu : Engine.values()) {
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
                Engine selectedEngine = null;
                for (Engine engine : Engine.values()) {
                    if (engine.getMenuIdx() == selection) {
                        selectedEngine = engine;
                        System.out.println("Wybrano " + i);
                        break;
                    }
                }
                System.out.println(selectedEngine.getDescription());

                if (saloonController.client.getBudget() >=
                        (selectedEngine.getPrice() + saloonController.carBuilder.getPriceWithoutEngine())) {
                    saloonController.carBuilder.setEngine(selectedEngine);
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
