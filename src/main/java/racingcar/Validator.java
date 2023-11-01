package racingcar;

public class Validator {
    public static void validateCarNames(String carNames) {
        if (carNames.length() > 5 || carNames.isEmpty()) {
            throw new IllegalArgumentException("입력된 문자를 다시 확인하세요.");
        }
    }

    public static String validateTryGames(String s) {
        if (!s.matches("^[1-9]+$")) {
            throw new IllegalArgumentException("게임 횟수에는 숫자만 입력 가능합니다.");
        }

        return s;
    }
}
