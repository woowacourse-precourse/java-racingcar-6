package racingcar.domain;

public class Car {
    private final Name name;
    private final int distance = 0;

    private Car(String inputName) {
        this.name = Name.nameOf(inputName);
    }

    public static Car nameOf(String name) {
        return new Car(name);
    }
}
