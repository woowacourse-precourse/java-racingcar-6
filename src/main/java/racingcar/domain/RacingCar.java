package racingcar.domain;

public class RacingCar {
    private String name;
    private int straightCount;

    public String getName() {
        return name;
    }

    public int getStraightCount() {
        return straightCount;
    }

    public void moveStraight() {
        straightCount++;
    }
}
