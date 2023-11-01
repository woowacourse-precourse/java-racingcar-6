package racingcar.util;

import java.util.List;

public class Exception {
    private static final int CAR_NAME_LIMIT_MAX = 5;
    private static final int CAR_NAME_LIMIT_MIN = 0;
    private static final String SPACE = " ";
    private final Parser parser = new Parser();
    public void checkCarNamesInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkLastIndexAndThrowException(input);
        List<String> carNameList = parser.parseCarNames(input);
        checkCarNameListDuplicationAndThrowException(carNameList);
        checkCarNameLengthAndSpaceThrowException(carNameList);
    }

    public void checkNumberOfPlayCountInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkNumberAndThrowException(input);
    }

    private void checkEmptyAndThrowException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void checkNumberAndThrowException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력하세요.");
        }
    }

    private void checkCarNameListDuplicationAndThrowException(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                checkEqualsAndThrowException(carNameList.get(i), carNameList.get(j));
            }
        }
    }

    private void checkLastIndexAndThrowException(String carName) {
        if (carName.lastIndexOf(",") == carName.length() - 1) {
            throwSpaceException();
        }
    }

    private void checkCarNameLengthAndSpaceThrowException(List<String> carNameList) {
        for (String carName : carNameList) {
            checkLengthAndThrowException(carName);
            checkSpaceAndThrowException(carName);
        }
    }
    private void checkSpaceAndThrowException(String carName) {
        if (carName.contains(SPACE)) {
            throwSpaceException();
        }
    }

    private void throwSpaceException() {
        throw new IllegalArgumentException("자동차 이름안에 공백을 제거하세요.");
    }




    private void checkLengthAndThrowException(String carName) {
        if (CAR_NAME_LIMIT_MAX < carName.length()) {
            throwMaxLengthException();
        }
        if (carName.length() < CAR_NAME_LIMIT_MIN) {
            throwMinLengthException();
        }
    }


    private void throwMaxLengthException() {
        throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LIMIT_MAX + "글자 이하여야 합니다.");
    }

    private void throwMinLengthException() {
        throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LIMIT_MIN + "글자 이상여야 합니다.");
    }


    private void checkEqualsAndThrowException(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException("자동차 이름이 중복입니다.");
        }
    }


}
