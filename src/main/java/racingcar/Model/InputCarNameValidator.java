package racingcar.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputCarNameValidator {
    private static final InputCarNameValidator singleton = new InputCarNameValidator();
    private static final String DELIMITER = ",";
    private static final int MINIMUM_CAR_COUNT_LENGTH = 2;
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE_FOR_CAR_NAME = "자동차 이름은 1글자 이상, 5글자 이하만 가능합니다.";
    private static final String ERROR_MESSAGE_FOR_RACING = "자동차 경주를 위한 자동차는 2대 이상이어야 합니다.";
    private static final String ERROR_MESSAGE_FOR_DUPLICATE = "중복된 이름이 존재합니다.";
    private static final String ERROR_MESSAGE_FOR_DELIMITER = "자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다.";

    private static final String ERROR_MESSAGE_FOR_FIRST_DELIMITER = "자동차 이름은 쉼표(,)로 시작할 수 없습니다.";
    private static final String ERROR_MESSAGE_FOR_LAST_DELIMITER = "자동차 이름은 쉼표(,)로 끝날 수 없습니다.";

    private static final String ENG_REGEX = "^[a-zA-Z,]*$";

    public static InputCarNameValidator getInstance() {
        return singleton;
    }

    public List<String> validateNameBeforeSplit(String userInput) {
        isContainDelimiter(userInput);
        isContainOtherLanguage(userInput);
        isFirstDelimiter(userInput);
        isLastDelimiter(userInput);
        return new ArrayList<>(Arrays.asList(userInput.split(DELIMITER)));
    }

    private void isFirstDelimiter(String userInput) {
        if (userInput.startsWith(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_FIRST_DELIMITER);
        }
    }

    private void isLastDelimiter(String userInput) {
        if (userInput.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LAST_DELIMITER);
        }
    }

    // 영어 외 문자가 포함되어 있는지 확인
    private void isContainOtherLanguage(String userInput) {
        if (!userInput.matches(ENG_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_CAR_NAME);
        }
    }

    // ,가 String에 포함되어 있는지 확인
    private void isContainDelimiter(String userInput) {
        if (!userInput.contains(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_DELIMITER);
        }
    }

    public List<String> validateNameAfterSplit(List<String> carNames) {
        isLessThanMinimumCarCountLength(carNames);
        isDuplicate(carNames);
        validateCarLength(carNames);
        return carNames;
    }

    // ,로 split한 String[]의 길이가 1보다 작은지 확인
    private void isLessThanMinimumCarCountLength(List<String> userInput) {
        if (userInput.size() < MINIMUM_CAR_COUNT_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_RACING);
        }
    }

    // 중복된 이름이 있는지 확인
    private void isDuplicate(List<String> userInput) {
        if (userInput.size() != userInput.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_DUPLICATE);
        }
    }

    private void validateCarLength(List<String> carNames) {
        for (String carName : carNames) {
            isCarNameMaxLength(carName);
            isCarNameMinLength(carName);
        }
    }

    // 자동차 이름 길이가 5를 초과하는지 확인
    private void isCarNameMaxLength(String carName) {
        if (carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_CAR_NAME);
        }
    }

    // 자동차 이름 길이가 1보다 작은지 확인
    private void isCarNameMinLength(String carName) {
        if (carName.length() < MINIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_CAR_NAME);
        }
    }
}
