package racingcar.domain.game;

public enum GameStatus {
    RUN,
    STOP;

    public boolean isRunning() {
        return this == RUN;
    }
}
