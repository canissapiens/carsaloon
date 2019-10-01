package states;

import controllers.MainController;

public abstract class AbstractState implements State {
    @Override
    public abstract void showMenu(MainController saloonController);
    public abstract void setValue(MainController saloonController);


}
