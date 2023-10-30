package racingcar.vo;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public int moveForward(boolean success) {
        if (success) {
            return position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
