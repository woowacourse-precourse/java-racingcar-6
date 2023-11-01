package racingcar.games.racing.util;

import java.util.Arrays;
import java.util.List;

public class RacingFormatter {
    private static final String SPLIT_POINT = ",";

    public List<String> reformatCarNames(String input) {
        List<String> origin = Arrays.stream(input.split(SPLIT_POINT)).toList();
        List<String> carNames = Arrays.stream(input.split(SPLIT_POINT))
                .filter(name -> !name.isEmpty() && name.length() <= 5)
                .toList();
        validateCarNames(origin.size(), carNames.size());
        return carNames;
    }

    public int reformatAttemptNumber(String input) {
        try {
            int attemptNumber = Integer.parseInt(input);
            return attemptNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

    private void validateCarNames(int beforeFilteringSize, int afterFilteringSize) {
        if (beforeFilteringSize != afterFilteringSize) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 이하만 가능합니다.");
        }
    }
}
