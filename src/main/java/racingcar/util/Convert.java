package racingcar.util;

import java.util.List;

public class Convert {

    public static List<String> stringToList(String inputValue) {
        return List.of(inputValue.split(","));
    }
}
