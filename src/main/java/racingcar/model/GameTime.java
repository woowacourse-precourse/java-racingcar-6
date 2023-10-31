package racingcar.model;

public class GameTime {
    private final int MINIMUM = 1;
    private final int MAXIMUM = 100;
    private final int TOTAL_GAME_TIME;

    private int currentGameTime = 0;

    public GameTime(int gameTime) {
        validateGameTime(gameTime);
        this.TOTAL_GAME_TIME = gameTime;
    }

    private void validateGameTime(int gameTime){
        if (gameTime < MINIMUM || gameTime > MAXIMUM) {
            throw new IllegalArgumentException(String.format("이동 횟수는 %d부터 %d까지 가능합니다.",MINIMUM,MAXIMUM));
        }
    }

    public void plusGameTime() {
        currentGameTime += 1;
    }

    public boolean isGameNotEnded() {
        return currentGameTime != TOTAL_GAME_TIME;
    }
}
