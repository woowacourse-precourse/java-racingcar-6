package racingcar.domain;

public class Car {
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }
    void move(boolean go) {
        if (go) {
            position += 1;
        }
    }
}