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
public class MainWindowController {
    @FXML
    private Label helloLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Button helloButton;

    @FXML
    private Button buttonOpenRegisterView;

    @FXML
    private Button buttonOpenLoginView;

    @Autowired
    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    public void setHelloText(ActionEvent actionEvent) {
        helloLabel.setText(nameField.getText());
        databaseManager.loadInitialData();
        databaseManager.printTestData();
    }

    public void openRegisterView (ActionEvent actionEvent){
        PictubeApplication.showView(RegisterWindowView.class);
    }

    public void openLoginView(){
        PictubeApplication.showView(LoginWindowView.class);

    }
}
