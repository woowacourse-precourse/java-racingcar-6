package service;

public class InputValidator {
    public static void carListValidate(String userInput) {
        String[] carArray = userInput.split(",");
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하셔야 합니다.");
        }
        carLengthValidate(carArray);
        validateInputHasSpace(userInput);
        carListStartWithComma(userInput);
    }

    public static void carListStartWithComma(String userInput) {
        if(userInput.startsWith(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 시작할 수 없습니다.");
        }
    }

    public static void carLengthValidate(String[] carArray) {
        for (String carName : carArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateInputHasSpace(final String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException("공백이 포함되어 있습니다.");
        }
    }

    public static void checkNumericInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static int roundInputSetAndValidate(String userInput) {
        if (userInput == null) {
            throw new IllegalArgumentException("시도 횟수를 입력하셔야 합니다.");
        }
        validateInputHasSpace(userInput);
        checkNumericInput(userInput);
        return Integer.parseInt(userInput);
    }
}
