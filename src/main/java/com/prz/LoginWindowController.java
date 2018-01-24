package com.prz;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@FXMLController
public class LoginWindowController {
    @FXML
    private Label loginLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button logInButton;
    @FXML
    private Button goBackButton;

    public void goBack(){
        loginTextField.clear();
        passwordTextField.clear();
        PictubeApplication.showView(MainWindowView.class);
    }

}
