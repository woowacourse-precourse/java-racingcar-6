package racingcar.validator;

public class RoundNumberValidator {

    public static void validate(String readLine) {
        checkBlank(readLine);
        checkDigit(readLine);
    }

    private static void checkBlank(String readLine) {
        if (readLine.isBlank()) {
            throw new IllegalArgumentException("빈칸입니다.");
        }
    }

    private static void checkDigit(String readLine) {
        for (int i = 0; i < readLine.length(); i++) {
            if (!Character.isDigit(readLine.charAt(i))) {
                throw new IllegalArgumentException("문자를 입력하였습니다.");
            }
        }
    }
}
