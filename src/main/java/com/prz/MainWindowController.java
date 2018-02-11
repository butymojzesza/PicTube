package com.prz;

import com.prz.DataBase.DatabaseManager;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class MainWindowController {

    @FXML
    private Button buttonOpenRegisterView;

    @FXML
    private Button buttonOpenLoginView;

    @FXML
    private MenuItem menuItem1;

    @FXML
    private MenuItem menuItem2;

    @FXML
    private MenuItem menuItem3;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Text temperature;


    @Autowired
    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    private String skin1 = getClass().getResource("skin1.css").toExternalForm();
    private String skin2 = getClass().getResource("skin2.css").toExternalForm();
    private String skin3 = getClass().getResource("skin3.css").toExternalForm();


    public void initialize() {
        PictubeApplication.getStage().setTitle("PicTube");
        PictubeApplication.getStage().setResizable(false);
//      PictubeApplication.getStage().initStyle(StageStyle.UNDECORATED);

        databaseManager.loadInitialData();
        databaseManager.printTestData();
    }
    public void openRegisterView () {
        PictubeApplication.showView(RegisterWindowView.class);
    }
    public void openLoginView(){ PictubeApplication.showView(LoginWindowView.class); }

    public void menuItem1(){
        PictubeApplication.getScene().getStylesheets().clear();
        PictubeApplication.setUserAgentStylesheet(null);
        PictubeApplication.getScene().getStylesheets().add(skin1);
    }
    public void menuItem2(){
        PictubeApplication.getScene().getStylesheets().clear();
        PictubeApplication.setUserAgentStylesheet(null);
        PictubeApplication.getScene().getStylesheets().add(skin2);
    }
    public void menuItem3(){
        PictubeApplication.getScene().getStylesheets().clear();
        PictubeApplication.setUserAgentStylesheet(null);
        PictubeApplication.getScene().getStylesheets().add(skin3);
    }

}
