package racingcar.util;

import java.util.List;

public class SeparationUtil {

    public static List<String> separationCarName(String carNames) {
        String[] separatedCarName = carNames.split(",");
        return List.of(separatedCarName);
    }
}
