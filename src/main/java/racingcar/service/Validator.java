package racingcar.service;

import racingcar.view.OutputView;

import java.util.Arrays;

public class Validator {
    private static final String NOT_VALID_LIST_LENGTH = "두 대 이상의 자동차 이름을 입력해주세요.";
    private static final String OVER_MAX_NAME_LENGTH = "자동차 이름은 5글자 이하만 가능합니다.";
    private static final String NAME_NULL_ERROR = "자동차 이름은 공백일 수 없습니다.";
    private static final String DUPLICATED_NAME_ERROR = "중복된 이름이 존재합니다.";
    private static final String NOT_POSITIVE_NUMBER_ERROR = "시도 횟수는 1 이상 입력 가능합니다.";
    private static final String NOT_A_NUMBER_ERROR = "시도 횟수는 숫자여야 합니다.";
    private static final int MIN_CAR_LIST = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public static boolean isValidCar(String userInput) {
        String[] carList = userInput.split(",");
        return isValidListLength(carList) && isValidNameLength(carList)
                && hasNotContainSpace(carList) && streamDuplicateCheck(carList);
    }

    public static boolean isValidNameLength(String[] carList) {
        for (String carName : carList) {
            if (carName.length() > MAX_NAME_LENGTH) {
                OutputView.showError(OVER_MAX_NAME_LENGTH);
                return false;
            }
        }
        return true;
    }

    public static boolean hasNotContainSpace(String[] carList) {
        for (String carName : carList) {
            if (carName.equals("") || carName.contains(" ")) {
                OutputView.showError(NAME_NULL_ERROR);
                return false;
            }
        }
        return true;
    }

    public static boolean streamDuplicateCheck(String[] carList) {
        if (carList.length != Arrays.stream(carList).distinct().count()) {
            OutputView.showError(DUPLICATED_NAME_ERROR);
            return false;
        }
        return true;
    }

    public static boolean isValidListLength(String[] carList) {
        if(carList.length <= MIN_CAR_LIST) {
            OutputView.showError(NOT_VALID_LIST_LENGTH);
            return false;
        }
        return true;
    }

    public static boolean isValidNum(String userInput) {
        try {
            int parseNum = Integer.parseInt(userInput);
            if (parseNum <= 0) {
                OutputView.showError(NOT_POSITIVE_NUMBER_ERROR);
                return false;
            }
        } catch (NumberFormatException e) {
            OutputView.showError(NOT_A_NUMBER_ERROR);
            return false;
        }
        return true;
    }
}
