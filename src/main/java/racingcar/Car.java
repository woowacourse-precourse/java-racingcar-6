package racingcar;

import static racingcar.Application.pick1DigitRandomNumber;

public class Car {
    private final String name;

    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void tryMoveForward() {
        if (pick1DigitRandomNumber() >= 4)
            this.position++;
    }
}
