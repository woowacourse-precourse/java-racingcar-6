package racingcar.domain;

public class Car {

    private final CarName carName;
    private long distance = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void move(MoveStatus moveStatus) {
        distance += moveStatus.getValue();
    }

    public long getDistance() {
        return distance;
    }
}
