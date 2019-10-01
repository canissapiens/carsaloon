package states;

import controllers.MainController;
import javafx.application.Platform;

public class FinalState extends AbstractState {
    @Override
    public void showMenu(MainController saloonController) {

        saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getLabel(
                100, 170, "Zamówiłeś samochód"
        ));

        saloonController.paneContainer.getChildren().add(saloonController.screenObjects.getLabel(
                100, 200, saloonController.car.toString()
        ));
    }

    @Override
    public void setValue(MainController saloonController) {
        Platform.exit();
    }
}
