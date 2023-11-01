package racingcar.utils;

public class InputValidator {

    public static void checkHasComma(String carNameInput) {
        boolean isContain = carNameInput.contains(",");

        if (!isContain) {
            throw new IllegalArgumentException();
        }
    }

    //TODO: 자동차 이름의 글자가 5이하가 아닐 경우 예외 처리 기능

    //TODO: 쉼표(,) 뒤에 아무 글자도 입력되지 않았을 경우 예외 처리 기능
}
