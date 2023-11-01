package racingcar;

import static racingcar.RandomGenerator.*;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrNot() {
        int randomValue = createRandomNumber();
        if (randomValue >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
