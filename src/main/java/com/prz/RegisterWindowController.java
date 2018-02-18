package com.prz;

import com.prz.DataBase.DatabaseManager;
import com.prz.Dto.UserDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@FXMLController
public class RegisterWindowController {
    private final static Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
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
    @FXML
    private Pane registerPane;
    @FXML
    private TextField likedHashtagTextField;
    @Autowired
    DatabaseManager databaseManager = DatabaseManager.getInstance();

    private UserDto userDto;

    public void goBack() {
        loginTextField.clear();
        passwordTextField.clear();
        passwordConfirmTextField.clear();
        nameTextField.clear();
        likedHashtagTextField.clear();
        PictubeApplication.showView(MainWindowView.class);
    }

    public void insertNewUser() {
        if ((loginTextField.getText().isEmpty()) || (passwordTextField.getText().isEmpty()) || (passwordConfirmTextField.getText().isEmpty()) || (nameTextField.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            logr.info("Nie wprowadzono wszystkich danych do formularza podczas rejestracji");
            if (Locale.getDefault().getLanguage() == "en") {
                alert.setTitle("Missing data");
                alert.setHeaderText("Please type all needed data");
                alert.show();
            } else {
                alert.setTitle("Brakujące dane");
                alert.setHeaderText("Wpisz wszystkie potrzebne dane");
                alert.show();

            }
        } else {
            List<String> hasztag = new ArrayList<String>();
            hasztag.add(likedHashtagTextField.getText().replace("#",""));
            userDto = new UserDto();
            userDto.setLogin(loginTextField.getText());
            userDto.setPassword(passwordTextField.getText());
            userDto.setName(nameTextField.getText());
            userDto.setLikeHasztags(hasztag);
           try {
               validator(passwordTextField.getText(),passwordConfirmTextField.getText());
           }
           catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                logr.warning("Błąd podczas rejestracji");
            if (Locale.getDefault().getLanguage() == "en") {
                alert.setTitle("Error during registration");
                alert.setHeaderText("Something went wrong :(");
                alert.show();
            } else {
                alert.setTitle("Błąd podczas rejestracji");
                alert.setHeaderText("Coś poszło nie tak :(");
                alert.show();

            }
           }
    }
    }

    public void validator(String password, String confirmPassword){
        if(password.equals(confirmPassword))
        {
            this.databaseManager.insertUser(userDto);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (Locale.getDefault().getLanguage() == "en") {
                alert.setTitle("Registration successful");
                alert.setHeaderText("Thank you for creating account");
                alert.show();
            } else {
                alert.setTitle("Rejestracja zakończona sukcesem!");
                alert.setHeaderText("Dziękujęmy za utworzenie konta");
                alert.show();

            }
            loginTextField.clear();
            passwordTextField.clear();
            passwordConfirmTextField.clear();
            nameTextField.clear();
            likedHashtagTextField.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            logr.warning("Hasła podane podczas rejestracji nie są takie same");
            if (Locale.getDefault().getLanguage() == "en") {
                alert.setTitle("Error during registration");
                alert.setHeaderText("Password are not the same");
                alert.show();
            } else {
                alert.setTitle("Błąd podczas rejestracji");
                alert.setHeaderText("Hasła nie są takie same");
                alert.show();

            }
        }
    }
}