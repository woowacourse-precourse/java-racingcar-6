package racingcar;

public class Car {
    private String name;
    private int gauge = 0;

    Car(String name) {
        this.name = name;
    }

    void advance() {
        this.gauge++;
    }
}
