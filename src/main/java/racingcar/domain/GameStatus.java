package racingcar.domain;

public enum GameStatus {

    IN_PROGRESS,
    END;

    public boolean isEnd() {
        return this == END;
    }

}
