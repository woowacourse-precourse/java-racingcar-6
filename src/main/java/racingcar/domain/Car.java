package racingcar.domain;

public class Car {
    private final String name;
    private int currentPosition;

    public Car(String name) {
        currentPosition = 0;
        this.name = name;
    }

    public void forward() {
        currentPosition++;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

}
