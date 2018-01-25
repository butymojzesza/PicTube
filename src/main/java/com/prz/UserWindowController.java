package com.prz;

import com.prz.Dto.UserDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


@FXMLController
public class UserWindowController {
    @FXML
    private Button backButton;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label loggedAs;

    private UserDto userDto;


    public void goBack(){
        PictubeApplication.showView(MainWindowView.class);
    }

    public void setUserNameLabel(){

        userNameLabel.setText("name usera");
    }

}
