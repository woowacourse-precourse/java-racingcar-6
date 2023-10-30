package racingcar.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int value) {
        this.position += value;
    }

    public int getPosition() {
        return position;
    }
}
