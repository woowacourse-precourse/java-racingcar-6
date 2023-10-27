package racingcar;

public class Car {
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition() {
        this.position += 1;
    }
}
