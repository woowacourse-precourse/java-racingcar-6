package racingcar.model;

public class GameCountValidator {
    public static void validateGameCount(String gameCount) {
        validateIsInteger(gameCount);
        validateIsNaturalNumber(gameCount);
    }

    private static void validateIsInteger(String gameCount) {
        if (!gameCount.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("게임 횟수는 숫자만 입력 가능합니다.");
        }
    }

    private static void validateIsNaturalNumber(String gameCount) {
        int count = Integer.parseInt(gameCount);
        if (count < 1) {
            throw new IllegalArgumentException("게임 횟수는 1 이상의 자연수만 입력 가능합니다.");
        }
    }
}
