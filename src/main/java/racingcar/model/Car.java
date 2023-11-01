package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car {
    private static final int FORWARD_STANDARD = 4;
    private static final int INCREASE_AMOUNT = 1;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void forward(NumberGenerator numberGenerator) {
        if (generateNumber(numberGenerator) >= FORWARD_STANDARD) {
            position += INCREASE_AMOUNT;
        }
    }

    private int generateNumber(NumberGenerator numberGenerator) {
        return numberGenerator.generate(MIN_NUMBER, MAX_NUMBER);
    }
}
