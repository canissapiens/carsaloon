package states;

import additives.ClientMenu;
import additives.MainMenu;
import controllers.MainController;

public class BuildCarState extends AbstractState {
    @Override
    public void showMenu(MainController saloonController) {

        double y = 70;
        for (MainMenu menu : MainMenu.values()) {
            saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getButton(
                    40, y, 120, menu.getDescription(),
                    e -> saloonController.setValue(String.valueOf(menu.getMenuIdx()))));

            y += 40;
        }
        if(saloonController.carBuilder.isCarComplete()){
            saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getButton(
                    40, 300, 120, "Zamów samochód",
                    e-> saloonController.setValue("Z")
            ));
        }
        // System.out.println("X -> Idę do konkurencji");
    }

    @Override
    public void setValue(MainController saloonController) {

        switch (saloonController.sentValue) {
            case "1":
                saloonController.setState(saloonController.choiceModelState);
                break;
            case "2":
                saloonController.setState(saloonController.choiceBodyState);
                break;
            case "3":
                saloonController.setState(saloonController.choiceEngineState);
                break;
            case "4":
                saloonController.setState(saloonController.choiceColorState);
                break;
            case "5":
                saloonController.setState(saloonController.choiceUpholsteryState);
                break;
            case "Z":
                saloonController.orderCar();
                saloonController.setState(saloonController.finalState);
                break;

            default:
        } // switch

    }
}
