package racingcar.Model;

public class Car {
    private String carName;
    private int location;
    private final int START_LOCATION = 0;

    public Car(String carName) {
        this.carName = carName;
        this.location = START_LOCATION;
    }

    public void MoveOneStepForward() {
        location += 1;
    }

    public int getLocation() {
        return location;
    }

    public String getCarName() {
        return carName;
    }

}
