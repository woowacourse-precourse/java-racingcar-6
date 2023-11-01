package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class GameUtil {

    public List<String> splitNamesByComma(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

}
