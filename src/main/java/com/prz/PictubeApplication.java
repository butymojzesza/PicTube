package com.prz;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class PictubeApplication extends AbstractJavaFxApplicationSupport {


    public static void main(String[] args){
//        Locale.setDefault(new Locale("en", "EN"));
        launchApp(PictubeApplication.class, mainWindowView.class, args);
    }
}
