package racingcar.domain;

public class GameTry {
    private int gameTry;

    public GameTry(String gameTry) {
        this.gameTry = parseInt(gameTry);
    }

    private int parseInt(String inputTry) {
        try {
            return Integer.parseInt(inputTry);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자를 입력해야 합니다.");
        }
    }

    public boolean isNotGameEnd() {
        return this.gameTry != 0;
    }

    public void decrease() {
        if (gameTry > 0) {
            this.gameTry--;
        }
    }
}
