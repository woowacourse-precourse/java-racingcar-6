package racingcar.util;

public class Validation {
    public static void validateNameInput(String[] list) {
        for (String input : list) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("5자 이하의 이름만 입력 가능합니다");
            }
        }
    }
    public static void validateNumber(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("음수는 입력 불가합니다.");
        }

        try {
            Integer.parseInt(String.valueOf(input)); // 문자열로 변환하고 정수로 다시 변환 시도
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
