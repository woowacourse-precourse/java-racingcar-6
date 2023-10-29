package racingcar.model;

public class CarName {

    private final String name;

    private CarName(String name) {
        validate(name);
        this.name = name;
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    private void validate(String name) {
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof CarName carName
                && name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
