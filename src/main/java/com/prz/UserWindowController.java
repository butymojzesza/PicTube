package com.prz;

import com.prz.DataBase.DatabaseManager;
import com.prz.Dto.PictureDto;
import com.prz.Dto.UserDto;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.FXMLView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.List;
import java.util.Locale;


@FXMLController
public class UserWindowController {
    @FXML
    private Button backButton;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label loggedAs;
    @FXML
    private Button nextImgButton;
    @FXML
    private Button searchButton;
    @FXML
    private TextField hashtagTextField;

    private UserDto userDto;

    @FXML
    private GridPane gpPictureView;
    @FXML
    private GridPane gpHasztagsPictures;

    @Autowired
    DatabaseManager databaseManager = DatabaseManager.getInstance();

    private List<PictureDto> listofPictures;
    private List<String> listofPicturesUrl;
    private List<PictureDto> listofPicWHasztag;
    private List<String> listofPicWHasztagUrl;

    public void openProfileView(){
        PictubeApplication.showView(ProfileWindowView.class);
    }

    public void goBack() {
        userNameLabel.setText("");
        PictubeApplication.showView(MainWindowView.class);
    }

    public void setUserNameLabel(String name) {
      userNameLabel.setText(name);
    }

    private void showImage(ImageView imgv){
        gpPictureView.add(imgv,1,1);
    }

    public void initialize() {
        this.listofPictures = this.databaseManager.getListOfPictures();
        this.listofPicturesUrl = this.databaseManager.getListOfPicturesUrl(this.listofPictures);
        List<String> pics;
        ImageView userImage;
        pics = this.listofPicturesUrl;
        Image image = new Image(getClass().getResource(pics.get(2)).toExternalForm());
        userImage = new ImageView(image);
        userImage.setFitHeight(250.0);
        userImage.setFitWidth(250.0);
//        userImage.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                    gpPictureView.add(userImage,1,1);
//            }
//        });
        gpPictureView.add(userImage, 0,0);
    }

    public void searchHashtag(){
        String hasztag = hashtagTextField.getText();
        this.listofPicWHasztag = this.databaseManager.findByHasztag(hasztag);
        this.listofPicWHasztagUrl = this.databaseManager.getListOfPicturesUrl(this.listofPicWHasztag);
        List<String> pics1;
        ImageView userImage1;
        pics1 = this.listofPicWHasztagUrl;
        try { for(int i=0; i < pics1.size(); i++) {
            Image image1 = new Image(getClass().getResource(pics1.get(i)).toExternalForm());
        userImage1 = new ImageView(image1);
        userImage1.setFitHeight(250.0);
        userImage1.setFitWidth(250.0);
        gpHasztagsPictures.add(userImage1, 0,i);}}
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (Locale.getDefault().getLanguage() == "en") {
                alert.setTitle("Hashtag not found");
                alert.setHeaderText("Please try search for different #");
                alert.show();
            } else {
                alert.setTitle("Nie znaleziono hasztaga");
                alert.setHeaderText("Spróbuj wyszukać innego #");
                alert.show();

            }
        }
    }
}