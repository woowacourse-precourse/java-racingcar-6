package racingcar.validator;

public class CarNameSplitValidator {
    private static final char NAME_SEPARATOR = ',';
    private static final String DOUBLE_USE_SEPARATOR = ",,";

    public static void validate(String readLine) {
        checkEmptyInput(readLine);
        checkInvalidSeparator(readLine);
    }

    private static void checkEmptyInput(String readLine) {
        if (readLine.isBlank()) {
            throw new IllegalArgumentException("빈칸이 입력되었습니다.");
        }
    }

    private static void checkInvalidSeparator(String readLine) {
        if (readLine.charAt(0) == NAME_SEPARATOR) {
            throw new IllegalArgumentException(",으로 시작할 수 없습니다.");
        }
        if (readLine.charAt(readLine.length() - 1) == NAME_SEPARATOR) {
            throw new IllegalArgumentException(",으로 끝날 수 없습니다.");
        }
        if (readLine.contains(DOUBLE_USE_SEPARATOR)) {
            throw new IllegalArgumentException("쉼표를 연속으로 사용하였습니다.");
        }
    }
}
