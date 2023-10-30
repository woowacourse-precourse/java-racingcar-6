package racingcar;

public class CarNameValidator {
    private static final char NAME_SEPARATOR = ',';

    public void checkEmptyInput(String readLine) {
        if (readLine.isBlank()) {
            throw new IllegalArgumentException("빈칸이 입력되었습니다.");
        }
    }

    public void checkInvalidSeparator(String readLine) {
        if (readLine.charAt(0) == NAME_SEPARATOR) {
            throw new IllegalArgumentException(",으로 시작할 수 없습니다.");
        }
        if (readLine.charAt(readLine.length() - 1) == NAME_SEPARATOR) {
            throw new IllegalArgumentException(",으로 끝날 수 없습니다.");
        }
        if (readLine.contains(",,")) {
            throw new IllegalArgumentException("쉼표를 연속으로 사용하였습니다.");
        }
    }
}
