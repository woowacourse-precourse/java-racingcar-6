package racingcar.domain;

public class Car extends Vehicle {

    private static final int SAME_RANK = 0;

    private final Integer INPUT_RANK;

    public Car(String name, Integer INPUT_RANK) {
        this.name = name;
        this.distance = new Distance();
        this.INPUT_RANK = INPUT_RANK;
    }

    @Override
    public void advance() {
        this.distance.increaseDistance();
    }

    @Override
    public int compareTo(Vehicle otherVehicle) {
        Car otherCar = (Car)otherVehicle;
        int compareResult = this.distance.compareTo(otherVehicle.distance);
        if (compareResult == SAME_RANK) {
            return this.INPUT_RANK - otherCar.INPUT_RANK;
        }
        return compareResult;
    }
}
