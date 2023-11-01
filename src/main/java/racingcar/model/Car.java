package racingcar.model;

public class Car {
    private int position = 0;
    private String name;
    public Car(String name) {
        this.name = name;
    }
    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }
    public void move() {
        position++;
    }
}
