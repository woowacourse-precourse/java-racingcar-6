package racingcar;

public class Car {

    private final Name name;

    public Car(String nameValue) {
        this.name = new Name(nameValue);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}