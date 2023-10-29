package racingcar.domain;

public enum GameStatus {

    IN_PROGRESS,
    END;

    public boolean isInProgress() {
        return this == IN_PROGRESS;
    }

}
