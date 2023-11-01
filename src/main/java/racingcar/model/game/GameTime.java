package racingcar.model.game;

public class GameTime {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 100;

    private final int totalGameName;
    private int currentGameTime = 0;

    public GameTime(int gameTime) {
        validateGameTime(gameTime);
        this.totalGameName = gameTime;
    }

    private void validateGameTime(final int gameTime) {
        if (gameTime < MINIMUM || gameTime > MAXIMUM) {
            throw new IllegalArgumentException(String.format("이동 횟수는 %d부터 %d까지 가능합니다.", MINIMUM, MAXIMUM));
        }
    }

    public void plusGameTime() {
        currentGameTime += 1;
    }

    public boolean isGameNotEnded() {
        return currentGameTime != totalGameName;
    }
}
