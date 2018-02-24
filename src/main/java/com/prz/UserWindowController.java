package com.prz;

import com.prz.DataBase.DatabaseManager;
import com.prz.Dto.PictureDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.logging.Logger;


@FXMLController
public class UserWindowController {
    private final static Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
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
    @FXML
    private GridPane gpSearchPicture;
    @FXML
    private ScrollPane scrollPaneForHashtagSearch;
    @FXML
    private ScrollPane scrollPaneForAllPictures;
    @FXML
    private TilePane tile;

    @Autowired
    DatabaseManager databaseManager = DatabaseManager.getInstance();

    private List<PictureDto> listofPicWHasztag;
    private List<String> listofPicWHasztagUrl;
    private List<PictureDto> listofPictures;
    private List<String> listofPicturesUrl;

    public void initialize (){
        this.listofPictures = this.databaseManager.getListOfPictures();
        this.listofPicturesUrl = this.databaseManager.getListOfPicturesUrl(listofPictures);
        ImageView imageView;
        for (int i=0;i< listofPicturesUrl.size();i++) {
            Image image = new Image(getClass().getResource(listofPicturesUrl.get(i)).toExternalForm());
            imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
            tile.getChildren().addAll(imageView);
        }
    }

    public void goBack() {
        hashtagTextField.clear();
        userNameLabel.setText("");
        scrollPaneForHashtagSearch.setVisible(false);
        scrollPaneForAllPictures.setVisible(true);
        PictubeApplication.showView(MainWindowView.class);
    }

    public void setUserNameLabel(String name) {
      userNameLabel.setText(name);
    }

    public void searchHashtag(){
        scrollPaneForAllPictures.setVisible(false);
        scrollPaneForHashtagSearch.setVisible(true);
        gpSearchPicture.getChildren().clear();
        RowConstraints rowConstraints = new RowConstraints(250.0);
        this.gpSearchPicture.getRowConstraints().add(rowConstraints);
        String hasztag = hashtagTextField.getText();
        this.listofPicWHasztag = this.databaseManager.findByHasztag(hasztag);
        this.listofPicWHasztagUrl = this.databaseManager.getListOfPicturesUrl(this.listofPicWHasztag);
        List<String> pics;
        ImageView userImage;
        int colIndex = 0; int rowIndex = 0;
        pics = this.listofPicWHasztagUrl;
        for(int i=0; i < pics.size(); i++) {
            if (i % 2 == 0 && i != 0){
                rowConstraints = new RowConstraints(250.0);
                this.gpSearchPicture.getRowConstraints().add(rowConstraints);
                rowIndex++;
            }
            Image image1 = new Image(getClass().getResource(pics.get(i)).toExternalForm());
            userImage = new ImageView(image1);
            userImage.setFitHeight(200.0);
            userImage.setFitWidth(200.0);
            gpSearchPicture.add(userImage,colIndex, rowIndex);
            colIndex++;
            if (colIndex==2){
                colIndex=0;
            }
        }
    }
}