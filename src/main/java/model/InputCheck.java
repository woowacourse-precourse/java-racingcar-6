package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputCheck {

    private static final String SEPERATOR = ",";

    public static List<String> name(String input) {

        List<String> nameList = Arrays.asList(input.split(SEPERATOR));

        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException();
        }

        return nameList;

    }

    public static int round(String input) {

        int round;

        try {
            round = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return round;

    }
}
