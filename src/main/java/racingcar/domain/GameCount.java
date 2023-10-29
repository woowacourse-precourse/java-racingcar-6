package racingcar.domain;

public class GameCount {

    private int gameCount;

    public GameCount(String userInput) {
        gameCount = Integer.parseInt(userInput);
    }

    public boolean hasRemainCount() {
        if (gameCount > 0) {
            gameCount--;
            return true;
        }
        return false;
    }
}
