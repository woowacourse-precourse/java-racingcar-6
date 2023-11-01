package racingcar.car;

import racingcar.validateName.ValidateNameImpl;

public class CarImpl implements Car {
    private String name;
    private int position = 0;

    public CarImpl(String name) {
        new ValidateNameImpl().validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
