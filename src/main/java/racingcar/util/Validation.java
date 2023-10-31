package racingcar.util;

import java.util.List;

public class Validation {

    private final Parsing parsing = new Parsing();
    private static final int CAR_NAME_LENGTH_MAX = 5;

    public void checkCarNamesInput(String input) throws IllegalArgumentException {
        checkInputIsEmpty(input);
        checkLastInputIndex(input);
        List<String> carList = parsing.parseCarNames(input);
        checkCarNameLength(carList);
        checkCarNameDuplicate(carList);
    }

    public void checkTrialInput(String input) throws IllegalArgumentException {
        checkInputIsEmpty(input);
        checkInputIsInteger(input);
    }

    private void checkCarNameContainSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 공백이 포함되어선 안됩니다.");
        }
    }

    private void checkInputIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자가 입력되어야 합니다.");
        }
    }

    private void checkCarNameDuplicate(List<String> carList) {
        for (int i = 0; i < carList.size(); i++) {
            for (int j = i + 1; j < carList.size(); j++) {
                ifCarNameDuplicate(carList, i, j);
            }
        }
    }

    private static void ifCarNameDuplicate(List<String> carList, int i, int j) {
        if (carList.get(i).equals(carList.get(j))) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복되면 안됩니다.");
        }
    }

    private void checkCarNameLength(List<String> carList) {
        for (String carName : carList) {
            checkCarNameLengthMax(carName);
            checkCarNameContainSpace(carName);
        }
    }

    private static void checkCarNameLengthMax(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    private void checkLastInputIndex(String input) {
        if (Character.compare(input.charAt(input.length() - 1), ',') == 0) {
            throw new IllegalArgumentException("[ERROR] 쉼표로 입력이 끝나면 안됩니다.");
        }
    }


    private void checkInputIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }
}
