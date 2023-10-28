package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final String MOVE_COUNT_NATURAL_NUMBER_REQUIRED = "이동횟수는 자연수여야합니다.";
    private static final String MOVE_COUNT_DIGIT_COUNT_IS_UNDER_NINE = "이동 횟수는 아홉 자릿수 이내여야 합니다.";
    private static final String MOVE_COUNT_CANT_ZERO = "이동횟수는 0이어서는 안됩니다.";
    private static final String CAR_NAME_LENGTH_BETWEEN_ONE_AND_FIVE = "자동차 이름의 길이는 1이상 5이하여야 합니다";
    private static final String UNIQUE_CAR_NAME_REQUIRED = "자동차 이름은 중복되면 안됩니다";
    private static final String TWO_OR_MORE_CAR_NAME_REQUIRED = "자동차 이름은 2개 이상 입력되어야 합니다";

    public boolean validateCarNames(String cars) throws IllegalArgumentException {
        List<String> carNameList = splitByDelimiter(cars, ",");

        validateCount(carNameList);

        for (String carName : carNameList) {
            validateCarName(carName);
        }

        validateDuplicate(carNameList);

        return true;
    }

    private static void validateCount(List<String> carNameList) {
        if (carNameList.size() <= 1) {
            throw new IllegalArgumentException(TWO_OR_MORE_CAR_NAME_REQUIRED);
        }
    }

    private void validateDuplicate(List<String> carNameList) {
        Set<String> set = new HashSet<>(carNameList);
        if (set.size() != carNameList.size()) {
            throw new IllegalArgumentException(UNIQUE_CAR_NAME_REQUIRED);
        }
    }

    private List<String> splitByDelimiter(String cars, String delimiter) {
        List<String> nameList = new ArrayList<>(List.of(cars.split(delimiter)));
        //split 함수의 경우 "효림,현진,"일 때 마지막 공백을 무시하므로 직접 공백 하나를 추가함
        if (cars.length() > 0 && cars.charAt(cars.length() - 1) == ',') {
            nameList.add("");
        }

        return nameList;
    }

    private void validateCarName(String carName) {
        carName = carName.strip();
        if (carName.length() == 0 || carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_BETWEEN_ONE_AND_FIVE);
        }
    }

    public void validateMoveCount(String moveCnt) {
        if (!isNaturalNumber(moveCnt)) {
            throw new IllegalArgumentException(MOVE_COUNT_NATURAL_NUMBER_REQUIRED);
        }

        if (!isDigitCountIsUnder9(moveCnt)) {
            throw new IllegalArgumentException(MOVE_COUNT_DIGIT_COUNT_IS_UNDER_NINE);
        }

        if (isZero(moveCnt)) {
            throw new IllegalArgumentException(MOVE_COUNT_CANT_ZERO);
        }
    }

    private boolean isNaturalNumber(String moveCnt) {
        if (moveCnt.matches("[0-9]+")) {
            return true;
        }

        return false;
    }

    private boolean isDigitCountIsUnder9(String moveCnt) {
        if (moveCnt.length() <= 9) {
            return true;
        }

        return false;
    }

    private boolean isZero(String moveCnt) {
        if (Integer.parseInt(moveCnt) == 0) {
            return true;
        }

        return false;
    }
}
