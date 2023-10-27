package racingcar.domain;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void addPosition() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
