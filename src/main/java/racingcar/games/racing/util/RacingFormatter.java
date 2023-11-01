package racingcar.games.racing.util;

import java.util.Arrays;
import java.util.List;

public class RacingFormatter {

    public List<String> reformatCarNames(String input) {
        List<String> origin = Arrays.stream(input.split(",")).toList();
        List<String> carNames = Arrays.stream(input.split(","))
                .filter(name -> !name.isEmpty() && name.length() <= 5)
                .toList();
        return carNames;
    }

}
