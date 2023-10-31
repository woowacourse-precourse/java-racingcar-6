package racingcar.model;

public enum RaceStatus {
    WIN, DRAW, LOSE;

    public boolean isWin() {
        return this == WIN;
    }

    public boolean isLose() {
        return this == LOSE;
    }
}
