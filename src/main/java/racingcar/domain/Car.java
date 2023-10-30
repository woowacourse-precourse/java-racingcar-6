package racingcar.domain;

public class Car {

    private String carName;
    private int carLocation;

    public void updateCarLocation(int carMoveDistance) {
        this.carLocation += carMoveDistance;
    }
}
