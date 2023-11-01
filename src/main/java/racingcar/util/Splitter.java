package racingcar.util;

import racingcar.enums.Constants;

public class Splitter {
    public static String[] splitName(String name) {
        String[] names = name.split(Constants.NAME_SPLITTER.getMessage());
        return names;
    }
}
