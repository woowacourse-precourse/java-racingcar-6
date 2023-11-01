package racingcar.model;

import static racingcar.util.Constants.GO_CONDITION;
import static racingcar.util.Constants.ZERO;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.validate.CarValidateImpl;


public class Car {
    private String name;
    private int position;

    public Car(String name) {
        CarValidateImpl.createValue(name);
        this.name = name;
        this.position = ZERO;
    }

    public void go(int randomValue) {
        if (randomValue >= GO_CONDITION) {
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


