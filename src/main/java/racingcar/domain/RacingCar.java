package racingcar.domain;

public class RacingCar implements Racing {
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
