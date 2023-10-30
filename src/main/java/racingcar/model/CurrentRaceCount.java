package racingcar.model;

public class CurrentRaceCount {
    private int currentValue;
    private static final int DEFAULT_VALUE = 1;

    private CurrentRaceCount(int currentValue) {
        this.currentValue = currentValue;
    }

    public static CurrentRaceCount createCurrentRaceCount() {
        return new CurrentRaceCount(DEFAULT_VALUE);
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void nextRound() {
        currentValue++;
    }
}
