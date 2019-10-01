package controllers;

import static main.Car.CarBuilder;

import comonObjects.ScreenObjects;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main.Calculator;
import main.Car;
import main.Client;
import states.*;

public class MainController {

    public final NoClientState noClientState = new NoClientState();
    public final SetNameState setNameState = new SetNameState();
    public final SetBudgetState setBudgetState = new SetBudgetState();
    public final ChoiceModelState choiceModelState = new ChoiceModelState();
    public final ChoiceBodyState choiceBodyState = new ChoiceBodyState();
    public final ChoiceEngineState choiceEngineState = new ChoiceEngineState();
    public final ChoiceColorState choiceColorState = new ChoiceColorState();
    public final ChoiceUpholsteryState choiceUpholsteryState = new ChoiceUpholsteryState();
    public final BuildCarState buildCarState = new BuildCarState();
    public final FinalState finalState = new FinalState();

    public Client client;
    public Car car;
    private State state;
    private int minimalBudget;
    private Calculator calc;
    public CarBuilder carBuilder;
    private String test;
    public String sentValue;

    public int badChoice;
    public String badStatement;

    @FXML
    public StackPane mainStackPane;
    public Pane paneContainer;
    public TextField textField;

    public ScreenObjects screenObjects;

    public MainController() {
        this.badChoice = 0;
        this.calc = new Calculator();
        this.minimalBudget = calc.getMinimalBudget();
        this.state = noClientState;
        this.carBuilder = new CarBuilder();
        System.out.println("Zainicjowany kontroler");
    }

    @FXML
    public void initialize() {
        this.paneContainer = new Pane();
        this.paneContainer.setMinHeight(400d);
        this.paneContainer.setMinWidth(800d);
        this.mainStackPane.getChildren().add(paneContainer);
        this.screenObjects = new ScreenObjects();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void showMenu() {

        if (mainStackPane.getChildren().size() > 0) {
            mainStackPane.getChildren().remove(0);
        }
        paneContainer = new Pane();
        paneContainer.setMinWidth(800);
        paneContainer.setMinHeight(400);
        mainStackPane.getChildren().add(paneContainer);

        if (this.badChoice < 3) {

            paneContainer.getChildren().add(screenObjects.getLabel(
                    40, 16, client.toString()
            ));

            if (carBuilder.getPrice() != 0) {
                paneContainer.getChildren().add(screenObjects.getLabel(
                        40, 32, String.valueOf(carBuilder.toString())
                ));
            }

            if (this.badStatement != null) {
                paneContainer.getChildren().add(screenObjects.getLabel(
                        40, 48, this.badStatement));
                this.badStatement = null;
            }

            this.state.showMenu(this);
        } else {
            paneContainer.getChildren().add(screenObjects.getLabel(
                    40, 16, "Pan wyjdzie sam, czy mam wezwać ochronę?"
            ));

        }
        this.paneContainer.getChildren().add(this.screenObjects.getButton(
                40, 360, 120, "Wyjdź",
                e -> setValue("X")));


    }

    public void setState(State state) {
        this.state = state;
    }

    public void setValue(String input) {

        if (input.equals("X")) {
            Platform.exit();
        }

        this.sentValue = input;
        this.state.setValue(this);
        int temp = 0;
        this.showMenu();
    }

    public void orderCar() {
        car = carBuilder.buildCar();
    }
}
