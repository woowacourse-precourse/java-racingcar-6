package racingcar.model;

public class Car {

    private final String name;
    private int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public String carName() {
        return this.name;
    }

    public void move() {
        this.count += 1;
    }

    public int moveCount() {
        return count;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
