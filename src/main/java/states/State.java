package states;

import controllers.MainController;

public interface State {

    State noClientState = new NoClientState();

    void showMenu(MainController saloonController);
    void setValue(MainController saloonController);
}
