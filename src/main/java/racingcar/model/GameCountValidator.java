package racingcar.model;

public class GameCountValidator {
    public static void gameCountValidation(String gameCount) {
        isInteger(gameCount);
    }

    private static void isInteger(String gameCount) {
        if (!gameCount.matches("^-?\\d+$\n")) {
            throw new IllegalArgumentException("게임 횟수는 숫자만 입력 가능합니다.");
        }
    }

}
