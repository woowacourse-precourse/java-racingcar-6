package racingcar;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;

    public String getName() {
        return name;
    }
}
