package racingcar.domain.car;

public class Car {
    private final Name name;
    private final int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public String getName() {
        return name.toString();
    }
}
