package racingcar.domain.game;

public enum CarStatus {
    RUN,
    STOP;

    public boolean isRunning() {
        return this == RUN;
    }
}
