package com.prz.Converter;

public class StringToList {

    public static String[] convertToArray(String string) {

        String noWhiteSpaceString = string.replaceAll("\\s+", "");
        String[] strings = noWhiteSpaceString.split(",");
        return strings;
    }
}
