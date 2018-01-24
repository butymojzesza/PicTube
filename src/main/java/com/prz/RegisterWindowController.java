package com.prz;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@FXMLController
public class RegisterWindowController {
    @FXML
    private Label loginLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label passwordConfirmLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField passwordConfirmTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private Button registerButton;
    @FXML
    private Button goBackButton;

    public void goBack(){
        loginTextField.clear();
        passwordTextField.clear();
        passwordConfirmTextField.clear();
        nameTextField.clear();
        PictubeApplication.showView(MainWindowView.class);
    }

}
