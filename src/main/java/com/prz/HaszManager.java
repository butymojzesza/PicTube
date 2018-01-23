package com.prz;

import java.util.ArrayList;
import java.util.List;

public class HaszManager {

    protected List<String> removeHasz(List<String> strings) {
        List<String> noHasz = new ArrayList<String>();
        if (strings != null) {
            for (String string : strings)
                noHasz.add(string.replaceAll("#", ""));
        }
        return noHasz;
    }

    protected List<String> addHasz(List<String> strings) {
        List<String> hasz = new ArrayList<String>();
        if (strings != null) {
            for (String string : strings)
                if (!string.contains(","))
                    hasz.add("#" + string);
                else hasz.add(string);
        }
        return hasz;
    }
}
