package racingcar.domain;

public class GameTry {
    private int gameTry;

    public GameTry(String gameTry) {
        this.gameTry = validateTry(parseInt(gameTry));
    }

    private int validateTry(int targetGameTry) {
        if (targetGameTry < 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상을 입력해야 합니다.");
        }
        return targetGameTry;
    }


    private int parseInt(String inputTry) {
        try {
            return Integer.parseInt(inputTry);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자를 입력해야 합니다.");
        }
    }

    public int getGameTry() {
        return gameTry;
    }

    public boolean isNotGameEnd(int TargetGameTry) {
        return this.gameTry != TargetGameTry;
    }

    public void increase() {
        this.gameTry++;
    }
}
