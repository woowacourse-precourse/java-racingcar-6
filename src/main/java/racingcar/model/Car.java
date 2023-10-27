package racingcar.model;

public class Car {
    private Name name;
    private String record;

    public Car(String name) {
        this.name = new Name(name);
    }
}
