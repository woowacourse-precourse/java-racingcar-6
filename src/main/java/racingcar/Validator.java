package racingcar;

import java.util.List;

public class Validator {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final String BLANK = " ";

    public void checkCarName(List<String> carNames) {
        for (String carName : carNames) {
            checkCarNameMaxLength(carName);
            checkCarNameMinLength(carName);
            checkCarNameBlank(carName);
        }
    }

    public void checkVaildNum(String input) {
        isNumeric(input);
    }

    private void checkCarNameMaxLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void checkCarNameMinLength(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상만 가능합니다.");
        }
    }

    private void checkCarNameBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형태의 값만 입력할 수 있습니다.");
        }
    }
}
