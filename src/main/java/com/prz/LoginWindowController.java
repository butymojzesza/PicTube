package com.prz;

import com.prz.DataBase.DatabaseManager;
import com.prz.Dto.PictureDto;
import com.prz.Dto.UserDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;

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
    @Autowired
    MainWindowController mainWindowController;
    @Autowired
    UserWindowController userWindowController;
    @Autowired
    DatabaseManager databaseManager = DatabaseManager.getInstance();

    private UserDto userDto;


    public void goBack() {
        loginTextField.clear();
        passwordTextField.clear();
        PictubeApplication.showView(MainWindowView.class);
    }

    public void logIn() {
        if ((loginTextField.getText().isEmpty()) || (passwordTextField.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (Locale.getDefault().getLanguage() == "en") {
                alert.setTitle("Missing data");
                alert.setHeaderText("Please type login and password");
                alert.show();
            } else {
                alert.setTitle("Brakujące dane");
                alert.setHeaderText("Wpisz login oraz hasło");
                alert.show();

            }
        } else {
            userDto = new UserDto();
            this.userDto = userDto.builder().login(loginTextField.getText()).password(passwordTextField.getText()).build();
            if (databaseManager.isAdmin(userDto)) {
                loginTextField.clear();
                passwordTextField.clear();
                PictubeApplication.showView(UserWindowView.class);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                if (Locale.getDefault().getLanguage() == "en") {
                    alert.setTitle("Error");
                    alert.setHeaderText("Wrong data");
                    alert.show();
                } else {
                    alert.setTitle("Błędne dane");
                    alert.setHeaderText("Podaj poprawny login oraz hasło");
                    alert.show();

                }
            }
        }
    }

}
