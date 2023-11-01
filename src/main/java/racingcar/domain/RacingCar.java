package racingcar.domain;

public class RacingCar {

    private static final String SPLITTER = " : ";
    private static final String REPEATER = "-";

    private final String name;
    private int advanceCount;

    public RacingCar(String name) {
        this.name = name;
        this.advanceCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void increaseCount() {
        advanceCount++;
    }

    @Override
    public String toString() {
        return name + SPLITTER + REPEATER.repeat(advanceCount);
    }
}
