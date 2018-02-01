package com.prz;

import com.prz.DataBase.DatabaseManager;
import com.prz.Dto.PictureDto;
import com.prz.Dto.UserDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.List;


@FXMLController
public class UserWindowController {
    @FXML
    private Button backButton;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label loggedAs;

    private UserDto userDto;

    @FXML
    private GridPane gpPictureView;

    @Autowired
    DatabaseManager databaseManager = DatabaseManager.getInstance();

    private List<PictureDto> listofPictures;
    private List<String> listofPicturesUrl;


    public void goBack() {
        PictubeApplication.showView(MainWindowView.class);
    }

    public void setUserNameLabel() {
      userNameLabel.setText("name");
    }

    public void initialize() {
        this.listofPictures = this.databaseManager.getListOfPictures();
        this.listofPicturesUrl = this.databaseManager.getListOfPicturesUrl(this.listofPictures);
        List<String> pics;
        ImageView userImage;
        pics = this.listofPicturesUrl;
        Image image = new Image(getClass().getResource(pics.get(0)).toExternalForm());
        userImage = new ImageView(image);
        userImage.setFitHeight(250.0);
        userImage.setFitWidth(250.0);
        gpPictureView.add(userImage, 1,1);
    }
}