package racingcar.domain.car.carcomponent.carposition;

public enum CarPositionCompareResult {
    BIG, SMALL, SAME;

    public boolean isBig() {
        return this.equals(BIG);
    }

    public boolean isSmall() {
        return this.equals(SMALL);
    }
}
