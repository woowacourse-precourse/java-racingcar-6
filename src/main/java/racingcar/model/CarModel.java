package racingcar.model;

import java.util.List;

public class CarModel {

    public static final int FORWARD_NUMBER = 4;
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

    public void forward(int randomNumber) {
        if (randomNumber >= FORWARD_NUMBER) {
            this.location++;
        }
    }
}
