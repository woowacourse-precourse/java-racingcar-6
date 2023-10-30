package racingcar.common;

import java.util.List;

public class Convert {
    public static List<String> stringToListByComma(String string) {
        return List.of(string.split(","));
    }
}
