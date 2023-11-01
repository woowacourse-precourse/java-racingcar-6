package racingcar.model;

public class RacingCar {

    private final String carName;
    private int currentPosition;

    public RacingCar(String carName) {
        this.carName = carName;
        this.currentPosition = 0;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void moveForwordOrNot() {

    }

    private boolean canMoveForward() {
        return false;
    }
}
