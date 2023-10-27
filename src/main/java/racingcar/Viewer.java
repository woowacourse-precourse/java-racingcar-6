package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Viewer {
    private final String CAR_NAME_DELIMITER = ",";
    private final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다.";
    private final String INVALID_CAR_NAME_DELIMITER = "쉼표(,)로 구분해주세요.";
    private final Integer MIN_TRY_COUNT = 1;
    private final String TRY_COUNT_ONLY_NUMBER = "시도 횟수는 숫자여야 합니다.";
    private final String MINIMUM_TRY_COUNT = "시도 횟수는 1 이상이어야 합니다.";

    public List<String> inputCarNames() {
        List<String> carNameList = Arrays.asList(readLine().split(CAR_NAME_DELIMITER));
        carNameList.forEach(this::validateCarName);
        return carNameList;
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

    private void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameType(carName);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }
    private void validateCarNameType(String carName) {
        if (Pattern.matches("^[a-zA-Z]*$", carName)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_DELIMITER);
        }
    }
    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(MINIMUM_TRY_COUNT);
        }
    }

}
