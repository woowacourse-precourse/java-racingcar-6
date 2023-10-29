package racingcar.game;

import java.util.Arrays;
import java.util.List;

public class StringSeparator {

    public static List<String> separate(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<String> carNameList = Arrays.asList(carNameArray);
        return carNameList;
    }
}
