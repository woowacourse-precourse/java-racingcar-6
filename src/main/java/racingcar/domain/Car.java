package racingcar.domain;

public class Car {
    private String name;
    private int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }
    public String getName() {
        return this.name;
    }
}
