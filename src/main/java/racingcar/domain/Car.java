package racingcar.domain;


import racingcar.utils.NumberGenerator;

public class Car {
    private static final int THRESHOLD = 4;
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;

    private final String carName;
    private int position = 0;
    private final NumberGenerator numberGenerator;

    public Car(String carName, NumberGenerator numberGenerator) {
        this.carName = carName;
        this.numberGenerator = numberGenerator;
    }

    public void moveByRandomNumber() {
        if (canMove())
            position++;
    }

    private boolean canMove() {
        int randomNumber = numberGenerator.generate();
        if (randomNumber >= MIN_BOUND && randomNumber <= MAX_BOUND) {
            return randomNumber >= THRESHOLD;
        }
        throw new IllegalArgumentException();
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}