package racingcar.model;

public class Car {

    private final CarName name;

    private Car(final String name) {
        this.name = CarName.from(name);
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Car car
                && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public CarName getName() {
        return name;
    }
}
