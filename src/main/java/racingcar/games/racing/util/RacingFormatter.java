package racingcar.games.racing.util;

import java.util.Arrays;
import java.util.List;

public class RacingFormatter {

    public List<String> reformatCarNames(String input) {
        List<String> origin = Arrays.stream(input.split(",")).toList();
        List<String> carNames = Arrays.stream(input.split(","))
                .filter(name -> !name.isEmpty() && name.length() <= 5)
                .toList();
        validateCarNames(origin.size(), carNames.size());
        return carNames;
    }

    private void validateCarNames(int beforeFilteringSize, int afterFilteringSize) {
        if (beforeFilteringSize != afterFilteringSize) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 이하만 가능합니다.");
        }
    }
}
