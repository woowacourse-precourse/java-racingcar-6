package racingcar;

public class Car {
    String name;
    int movingCount;

    public Car(String carName, int count) {
        this.name = carName;
        this.movingCount = count;
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }
}
