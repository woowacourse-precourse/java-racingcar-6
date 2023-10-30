package racingcar.domain;

public class Car {
    private final Name name;
    private int position = 0;

    private Car(Name name) {
        this.name = name;
    }

    public void changePosition() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public static Car of(Object name) {
        return new Car(Name.of(name));
    }
}
