package comonObjects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;

public class ScreenObjects {

    public Button getButton (double posX, double posY, double minWidth, String text, EventHandler<ActionEvent> event){
        Button button = new Button();
        button.setLayoutX(posX);
        button.setLayoutY(posY);
        button.setMinWidth(minWidth);
        button.setText(text);
        button.setOnAction(event);
        return button;
    }

    public Label getLabel (double posX, double posY, String text)
    {
        Label label = new Label(text);
        label.setLayoutX(posX);
        label.setLayoutY(posY);
        return label;
    }

    public TextField getTextField (double posX, double posY, double minWidth, double minHeight, String id){
        TextField textField = new TextField();
        textField.setLayoutX(posX);
        textField.setLayoutY(posY);
        textField.setMinSize(minWidth, minHeight);
        textField.setId(id);

        return textField;
    }

    public TextField getTextField (double posX, double posY, double minWidth, double minHeight, String id, String text){
        TextField textField = new TextField(text);
        textField.setLayoutX(posX);
        textField.setLayoutY(posY);
        textField.setMinSize(minWidth, minHeight);
        textField.setId(id);
        return textField;
    }
}
