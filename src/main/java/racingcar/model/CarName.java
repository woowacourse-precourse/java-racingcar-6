package racingcar.model;

public class CarName {

    private final String name;

    public CarName(String carName) {
        this.name = carName;
    }

    @Override
    public String toString() {
        return name;
    }
}
