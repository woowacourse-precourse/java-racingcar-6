package racingcar.domain;

public class Car {
    final String name;
    int position;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        position += 1;
    }
}
