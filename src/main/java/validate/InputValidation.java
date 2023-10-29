package validate;

public class InputValidation {

    public static void validateNumericInput(String input) {
        if (!input.matches("^[0-9]+$")){
            throw new IllegalArgumentException("입력된 값에 문자열이 포함되어있습니다.");
        }
    }
}
