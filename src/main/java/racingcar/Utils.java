package racingcar;

import java.util.List;

public class Utils {

    static void checkOverFive(List<String> names) {
        for(String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
