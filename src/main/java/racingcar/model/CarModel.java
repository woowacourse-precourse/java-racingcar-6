package racingcar.model;

import java.util.List;

public class CarModel {
    private final String name;
    private int location;

    public CarModel(String carName) {
        this.name = carName;
        this.location = 0;
    }
    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void increaseLocation(int randomNumber) {
        if (randomNumber >= 4) {
            this.location++;
        }
    }

    public boolean compareMaxLocation(int a) {
        return this.location >= a;
    }

}
