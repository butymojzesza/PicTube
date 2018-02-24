package com.prz;

import com.prz.DataBase.DatabaseManager;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Logger;

@FXMLController
public class MainWindowController {
    private final static Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    @FXML
    private Button buttonOpenRegisterView;

    @FXML
    private Button buttonOpenLoginView;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Text yahooThings;


    @Autowired
    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    private String skin1 = getClass().getResource("skin1.css").toExternalForm();
    private String skin2 = getClass().getResource("skin2.css").toExternalForm();
    private String skin3 = getClass().getResource("skin3.css").toExternalForm();


    public void initialize() throws SAXException, ParserConfigurationException {
        PictubeApplication.getStage().setTitle("PicTube");
        PictubeApplication.getStage().setResizable(false);
        yahoo();
        databaseManager.loadInitialData();
        logr.info("Wczytano pomyślnie bazę");
    }

    public void openRegisterView() {
        PictubeApplication.showView(RegisterWindowView.class);
    }

    public void openLoginView() {
        PictubeApplication.showView(LoginWindowView.class);
    }

    private void yahoo() throws ParserConfigurationException, SAXException {
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%20523920&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db =  dbf.newDocumentBuilder();
        Document doc = null;
        try {
            doc = db.parse(url);
        } catch (IOException e) {
            logr.severe("Zapytanie Yahoo nie działa" + e);
        }
        NodeList meteo = doc.getElementsByTagName("yweather:condition");
        yahooThings.setText( meteo.item(0)
                .getAttributes().getNamedItem("date").getNodeValue()+ ", " + meteo.item(0)
                .getAttributes().getNamedItem("temp").getNodeValue() +"F");

    }
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
