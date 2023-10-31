package racingcar.model;

public class GameCountValidator {
    public static void gameCountValidation(String gameCount) {
        isInteger(gameCount);
        isNaturalNumber(gameCount);
    }

    private static void isInteger(String gameCount) {
        if (!gameCount.matches("^-?\\d+$\n")) {
            throw new IllegalArgumentException("게임 횟수는 숫자만 입력 가능합니다.");
        }
    }

    private static void isNaturalNumber(String gameCount) {
        if (Integer.parseInt(gameCount) < 1) {
            throw new IllegalArgumentException("게임 횟수는 1 이상의 자연수만 입력 가능합니다.");
        }
    }
}
