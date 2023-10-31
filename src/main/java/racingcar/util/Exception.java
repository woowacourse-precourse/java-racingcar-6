package racingcar.util;

import java.util.List;

public class Exception {
    private static final int CAR_NAME_LIMIT_MAX = 5;
    private static final String SPACE = " ";
    private final Parser parser = new Parser();
    public void checkCarNamesInput(String input) throws IllegalArgumentException {
        List<String> carNameList = parser.parseCarNames(input);
        checkLengthAndThrowException(input);
        checkSpaceAndThrowException(input);
        checkEmptyAndThrowException(input);
        checkCarNameListDuplicationAndThrowException(carNameList);
    }

    private void checkSpaceAndThrowException(String carName) {
        if (carName.contains(SPACE)) {
            throwSpaceException();
        }
    }

    private void throwSpaceException() {
        throw new IllegalArgumentException("자동차 이름안에 공백을 제거하세요.");
    }

    private void checkEmptyAndThrowException(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }
    }

    private void checkLengthAndThrowException(String carName) {
        if (CAR_NAME_LIMIT_MAX < carName.length()) {
            throwMaxLengthException();
        }
    }


    private void throwMaxLengthException() {
        throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LIMIT_MAX + "글자 이하여야 합니다.");
    }

    private void checkCarNameListDuplicationAndThrowException(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                checkEqualsAndThrowException(carNameList.get(i), carNameList.get(j));
            }
        }
    }

    private void checkEqualsAndThrowException(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException("자동차 이름이 중복입니다.");
        }
    }
}
