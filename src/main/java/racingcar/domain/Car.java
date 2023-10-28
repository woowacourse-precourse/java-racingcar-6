package racingcar.domain;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        this.name =  name;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
