package racingcar;

import java.util.List;
import java.util.ArrayList;

public class Car {
    private String carName;
    private List<Character> steps = new ArrayList<>();

    public Car(String carName) {
        this.carName = carName;
    }

    public void moveForward() {
        this.steps.add('-');
    }
    public String name() {
        return this.carName;
    }

    public String movementHistory() {
        return this.steps.toString();
    }

}