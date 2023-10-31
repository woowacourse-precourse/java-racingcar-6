package racingcar.validation;

import static racingcar.constant.ValidationConstants.MAX_LENGTH_OF_NAME;

public class NameInputValidation {

    public void isUnderFiveLetters(String input) {
        if (input.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
