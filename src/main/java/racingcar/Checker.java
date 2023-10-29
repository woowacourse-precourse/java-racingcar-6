package racingcar;

import java.util.List;

public class Checker {
    public static Boolean isNameAllCorrect(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }

        return true;
    }
}
