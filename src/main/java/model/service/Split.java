package model.service;

import java.util.Arrays;
import java.util.List;

public class Split {

    private static final String SEPERATOR = ",";

    public static List<String> byComma(String input) {
        return Arrays.asList(input.split(SEPERATOR));
    }
}
