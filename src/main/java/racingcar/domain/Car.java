package racingcar.domain;

public class Car extends Vehicle {

    private final Integer INPUT_RANK;

    public Car(String name, Integer INPUT_RANK) {
        this.name = name;
        this.distance = new Distance();
        this.INPUT_RANK = INPUT_RANK;
    }

    public void printName() {
        String nameString = this.name + " : ";
        System.out.print(nameString);
    }

    public void printDistance() {
        this.distance.printDistance();
    }

    @Override
    public void advance() {
        this.distance.increaseDistance();
    }

    @Override
    public int compareTo(Vehicle otherVehicle) {
        Car otherCar = (Car)otherVehicle;
        int compareResult = this.distance.compareTo(otherVehicle.distance);
        if (compareResult == 0) {
            return this.INPUT_RANK - otherCar.INPUT_RANK;
        }
        return compareResult;
    }
}
