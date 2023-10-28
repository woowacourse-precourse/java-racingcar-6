package racingcar.model;

import java.util.List;

public class CarModel {
    private final String name;
    private int location;

    public CarModel(String carName) {
        this.name = carName;
        this.location = 0;
    }

    public void increaseLocation() {
        this.location++;
    }

    public String carLocationState() {
        StringBuilder result = new StringBuilder();

        result.append(name).append(" : ");
        result.append("-".repeat(Math.max(0, location)));
        return result.toString();
    }

}
