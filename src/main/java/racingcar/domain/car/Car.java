package racingcar.domain.car;

public class Car {

    private final String name;
    private int position;

    public Car(final String name) {
        CarNameValidator.validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
