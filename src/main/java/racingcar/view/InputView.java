package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Viewer {
    private final String CAR_NAME_DELIMITER = ",";
    private final String INVALID_INPUT_TYPE = "입력은 자동차 이름과 구분자(,)만 가능합니다.";
    private final Integer MIN_TRY_COUNT = 1;
    private final String TRY_COUNT_ONLY_NUMBER = "시도 횟수는 숫자여야 합니다.";
    private final String MINIMUM_TRY_COUNT = "시도 횟수는 1 이상이어야 합니다.";

    private String input() {
        String input = readLine();
        validateInputType(input);
        return input;
    }

    public List<String> inputCarNames() {
        return Arrays.asList(input().split(CAR_NAME_DELIMITER));
    }

    public int inputTryCount() {
        try {
            int tryCount = Integer.parseInt(readLine());
            validateTryCount(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_ONLY_NUMBER);
        }
    }

    private void validateInputType(String carName) {
        if (!Pattern.matches("^[a-zA-Z,]*$", carName)) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE);
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(MINIMUM_TRY_COUNT);
        }
    }
}
