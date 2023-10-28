package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingManager {
    public List<String> splitCarName(String carName) {
        return Arrays.stream(carName.split(",")).toList();
    }
}
