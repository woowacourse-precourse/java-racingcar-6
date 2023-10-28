package racingcar.util;

public class Validation {
    public static void validateNameInput(String[] list) {
        for (String input : list) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("5자 이하의 이름만 입력 가능합니다");
            }
        }
    }
}
