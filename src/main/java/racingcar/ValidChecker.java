package racingcar;

import racingcar.View.OutputView;

import java.util.Arrays;

public class ValidChecker {

    private final String NOT_VALID_LIST_LENGTH = "두 대 이상의 자동차 이름을 입력해주세요.";
    private final String NOT_VALID_NAME_LENGTH = "자동차 이름은 5글자 이하만 가능합니다.";
    private final String NAME_NULL_ERROR = "자동차 이름은 공백일 수 없습니다.";
    private final String DUPLICATED_NAME_ERROR = "중복된 이름이 존재합니다.";
    private final String HAVE_TO_OVER_ZERO_ERROR = "시도 회수는 1보다 이상만 입력 가능합니다.";
    private final String NOT_VALID_NUMBER_ERROR = "시도 횟수는 숫자여야 합니다.";

    private final int MIN_CAR_LIST = 1;
    private final int MAX_NAME_LENGTH = 5;
    private final String NULL = "";
    private final String SPACE = " ";
    private final String SEPARATOR = ",";

    public boolean isValidCar(String userInput) {
        String[] carList = userInput.split(SEPARATOR);
        return isValidListLength(carList) && isValidNameLength(carList)
                && hasNotContainSpace(carList);
    }

    private boolean isValidNameLength(String[] carList) {
        for (String carName : carList) {
            if (carName.length() > MAX_NAME_LENGTH) {
                OutputView.printError(NOT_VALID_NAME_LENGTH);
                return false;
            }
        }
        return true;
    }

    private boolean hasNotContainSpace(String[] carList) {
        for (String carName : carList) {
            if (carName.equals(NULL) || carName.contains(SPACE)) {
                OutputView.printError(NAME_NULL_ERROR);
                return false;
            }
        }
        return true;
    }

    /*
    private boolean streamDuplicateCheck(String[] carList) {
        if (Arrays.stream(carList).anyMatch(car -> car.equals(car))) {
            OutputView.printError(DUPLICATED_NAME_ERROR);
            return false;
        }
        return true;
    }
    */
    private boolean isValidListLength(String[] carList) {
        if(carList.length <= MIN_CAR_LIST) {
            OutputView.printError(NOT_VALID_LIST_LENGTH);
            return false;
        }
        return true;
    }

    public boolean isValidNum(String userInput) {
        try {
            int parseNum = Integer.parseInt(userInput);
            if (parseNum <= 0) {
                OutputView.printError(HAVE_TO_OVER_ZERO_ERROR);
                return false;
            }
        } catch (NumberFormatException e) {
            OutputView.printError(NOT_VALID_NUMBER_ERROR);
            return false;
        }
        return true;
    }
}
