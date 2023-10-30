package racingcar.utils;

public class Utils {
    public static void validateStringSeparateWithComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차의 이름은 쉼표(,) 기준으로 구분되어야 합니다.");
        }
    }
}
