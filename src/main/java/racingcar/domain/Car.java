package racingcar.domain;

public class Car {
    private String name;
    private int move;

    private Car() {

    }

    public Car(String name) {
        if (!nameLengthCheck(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.move = 0;
    }

    public void forward() {
        this.move++;
    }

    public int currentLocation() {
        return this.move;
    }

    public String myCarName() {
        return this.name;
    }

    public boolean nameLengthCheck(String name) {
        return name.length() <= 5;
    }
}
