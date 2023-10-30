package racingcar.vo;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public int moveForward(boolean success) {
        if (success) {
            position++;
        }
        return position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }
}
