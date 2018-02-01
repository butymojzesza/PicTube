package com.prz;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
