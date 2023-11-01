package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.validate.CarValidateImpl;


public class Car {
    private String name;
    private int position;
    private Car car;

    public Car(String name) {
        CarValidateImpl.createVaule(name);
        this.name = name;
        this.position = 0;
    }

    public void go(int randomValue) {
        if (randomValue >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isPositionEqualOrGreater(int otherPosition) {
        return this.position >= otherPosition;
    }

}


