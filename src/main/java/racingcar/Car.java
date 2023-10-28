package racingcar;

public class Car {
    String carName;
    Long totalMovements;

    public Car(String name) {
        this.carName = name;
        this.totalMovements = 0L;
    }

    public String getCarName() {
        return carName;
    }

    public Long getToTalMovements() {
        return totalMovements;
    }
}
