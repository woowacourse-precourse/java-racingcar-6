package racingcar.model;

public class CarModel {
    private final String name;
    private int location;

    public CarModel(String carName) {
        this.name = carName;
        this.location = 0;
    }

    public int increaseLocation() {
        this.location++;
        return this.location;
    }
}
