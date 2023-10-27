package racingcar.domain;

public class Car {
    private final String name;
    private int raceDistance;
    private static final int START_MOVING_VALUE = 4;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= START_MOVING_VALUE) {
            this.raceDistance++;
            return;
        }
    }


    @Override
    public String toString() {
        return name+" : "+"-".repeat(raceDistance);
    }
}
