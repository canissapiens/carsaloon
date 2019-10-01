package states;

import additives.Color;
import additives.Model;
import controllers.MainController;

public class ChoiceColorState extends AbstractState {
    @Override
    public void showMenu(MainController saloonController) {
        double y = 70;
        for (Color color : Color.values()) {
            saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getButton(
                    40, y, 120, color.getDescription(),
                    e -> saloonController.setValue(String.valueOf(color.getMenuIdx()))));

            saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getLabel(
                    200, y + 4, String.valueOf(color.getPrice())
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
                Color selectedColor = null;
                for (Color color : Color.values()) {
                    if (color.getMenuIdx() == selection) {
                        selectedColor = color;
                        System.out.println("Wybrano " + i);
                        break;
                    }
                }
                System.out.println(selectedColor.getDescription());

                if (saloonController.client.getBudget() >=
                        (selectedColor.getPrice() + saloonController.carBuilder.getPriceWithoutColor())) {
                    saloonController.carBuilder.setColor(selectedColor);
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
