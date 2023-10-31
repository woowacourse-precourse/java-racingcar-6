package racingcar.domain;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        this.position = 0;
        this.name =  name;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }
}
