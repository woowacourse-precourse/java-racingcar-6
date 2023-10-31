package racingcar.validator;

public class InputValidator {

    // 11. 자동차 이름이 5글자 이하인지 검사하는 메서드
    public static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }


}
