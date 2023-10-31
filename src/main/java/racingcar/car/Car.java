package racingcar.car;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int carPosition() {
        return this.position;
    }

    public String carName() {
        return this.name;
    }

    public void moveCar() {
        this.position++;
    }

}
