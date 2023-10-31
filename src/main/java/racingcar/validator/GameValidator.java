package racingcar.validator;

public class GameValidator {
    public static void validationCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 입력 가능합니다.");
        }
    }

    public static void validationMoveCntIsNumber(String moveCnt) {
        if (!moveCnt.matches("-?\\d+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
