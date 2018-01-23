package com.prz;

import com.prz.DataBase.DatabaseManager;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class mainWindowController {
    @FXML
    private Label helloLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Button helloButton;

    @Autowired
    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    public void setHelloText(ActionEvent actionEvent) {
        helloLabel.setText(nameField.getText());
        databaseManager.loadInitialData();
        databaseManager.printTestData();
    }
}
