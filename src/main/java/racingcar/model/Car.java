package racingcar.model;

import racingcar.utils.NumberGenerator;

public class Car {

    private String name;
    private int position;

    private final int STANDARD_NUMBER = 4;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        if(isOkToMove()) {
            position++;
        }
    }

    private boolean isOkToMove() {
        int RANDOM_NUMBER = numberGenerator.generateNumberInRange();

        if(RANDOM_NUMBER < STANDARD_NUMBER) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
