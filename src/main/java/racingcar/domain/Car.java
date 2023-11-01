package racingcar.domain;

import static racingcar.util.Validate.isValidCarName;

public class Car {
    private final String name;
    private Integer position = 0;

    public Car(String name) {
        isValidCarName(name);
        this.name = name;
    }

    public void forward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
