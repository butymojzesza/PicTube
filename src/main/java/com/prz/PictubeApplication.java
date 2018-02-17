package com.prz;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Locale;
import java.util.logging.*;

@SpringBootApplication
public class PictubeApplication extends AbstractJavaFxApplicationSupport {

    private final static Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );

    private static void setupLogger() {
        LogManager.getLogManager().reset();
        logr.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logr.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("logr.log");
            fh.setLevel(Level.FINE);
            logr.addHandler(fh);
        } catch (java.io.IOException e) {
            logr.log(Level.SEVERE, "Loggowanie do pliku nie działa", e);
        }
    }

    public static void main(String[] args){
        setupLogger();
        Locale.setDefault(new Locale("en", "EN"));
        launchApp(PictubeApplication.class,MainWindowView.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }
}
