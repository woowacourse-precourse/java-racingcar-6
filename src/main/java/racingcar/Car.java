package racingcar;

public class Car {
    private String name;
    private int carDistance;

    public Car(String name) {
        this.name = name;
    }

    public void increaseCarDistance() {
        this.carDistance++;
    }

    public String getName() {
        return name;
    }

    public int getCarDistance() {
        return carDistance;
    }
}
