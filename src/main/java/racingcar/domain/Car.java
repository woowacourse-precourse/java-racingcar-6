package racingcar.domain;

public class Car {
    private static final int NUMBER_OF_ADVANCE = 4;
    private final String name;
    private final AdvanceCount advanceCount;

    public Car(String name) {
        this.name = name;
        this.advanceCount = new AdvanceCount();
    }

    public void accumulate(int randomNumber) {
        if (randomNumber == NUMBER_OF_ADVANCE) {
            this.advanceCount.accumulate();
        }
    }

    public String getName() {
        return this.name;
    }

    public int getAdvanceCount() {
        return this.advanceCount.getCount();
    }
}