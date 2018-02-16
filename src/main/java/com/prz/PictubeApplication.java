package com.prz;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.NodeList;

import java.util.Locale;

@SpringBootApplication
public class PictubeApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args){
        Locale.setDefault(new Locale("en", "EN"));
        launchApp(PictubeApplication.class,MainWindowView.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }
}
