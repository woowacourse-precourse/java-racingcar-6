package racingcar.utils;

public class InputValidator {

    public static void checkHasComma(String carNameInput) {
        boolean isContain = carNameInput.contains(",");

        if (!isContain) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkEndsWithComma(String carNameInput) {
        if (carNameInput.charAt(carNameInput.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }
    }

    //TODO: 자동차 이름의 글자가 5이하가 아닐 경우 예외 처리 기능
}
