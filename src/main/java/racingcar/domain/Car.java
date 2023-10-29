package racingcar.domain;

public class Car {
    private Name carName;
    private int position;
    private Car(String carName) {
        this.carName = Name.of(carName);
        this.position = 0;
    }

    public static Car createCar(String carName) {
        return new Car(carName);
    }

    public void moveForward() {
        position++;
    }

    @Override
    public String toString() {
        return carName + " : " + convertPositionToResult();
    }

    private String convertPositionToResult() {
        return "-".repeat(position);
    }
}
