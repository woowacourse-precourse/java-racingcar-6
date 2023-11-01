package racingcar.util;

import java.util.List;

public class Validator {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String SPACE = " ";
    private final Parser parser = new Parser();

    // 입력된 자동차 이름의 유효성을 검사
    public void validateCarNamesInput(String input) {
        checkEmptyAndThrowException(input);
        checkLastIndexAndThrowException(input);
        List<String> carNameList = parser.parseCarNames(input);
        checkCarNameListDuplicationAndThrowException(carNameList);
        checkEachCarNameLengthAndSpaceThrowException(carNameList);
    }

    private void checkEachCarNameLengthAndSpaceThrowException(List<String> carNameList) {
        for (String carName : carNameList) {
            checkLengthAndThrowException(carName);
            checkSpaceAndThrowException(carName);
        }
    }

    public void validateNumberOfTrialsInput(String input) throws IllegalArgumentException{
        checkEmptyAndThrowException(input);
        checkCharAndThrowException(input);
    }

    private void checkCharAndThrowException(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자여야 합니다.");
        }
    }

    private void checkEmptyAndThrowException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private void checkEqualsAndThrowException(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException("[ERROR] 같은 이름을 가진 자동차가 있습니다.");
        }
    }

    private void checkCarNameListDuplicationAndThrowException(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                checkEqualsAndThrowException(carNameList.get(i), carNameList.get(j));
            }
        }
    }


    private void checkLastIndexAndThrowException(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throwMinLengthException();
        }
    }

    private void checkLengthAndThrowException(String carName) {
        if (MAX_CAR_NAME_LENGTH < carName.length()) {
            throwMaxLengthException();
        }
        if (carName.length() < MIN_CAR_NAME_LENGTH) {
            throwMinLengthException();
        }
    }

    private void throwMinLengthException() {
        throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + MIN_CAR_NAME_LENGTH + "글자 이상이어야 합니다.");
    }

    private void throwMaxLengthException() {
        throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + MAX_CAR_NAME_LENGTH + "글자 이하여야 합니다.");
    }

    private void checkSpaceAndThrowException(String carName) {
        if (carName.contains(SPACE)) {
            throwSpaceException();
        }
    }

    private void throwSpaceException() {
        throw new IllegalArgumentException("[ERROR] 자동차 이름안에는 공백이 있어서는 안됩니다.");
    }

}