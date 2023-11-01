package racingcar.domain;


import racingcar.utils.NumberGenerator;

public class Car {

    private static final int THRESHOLD = 4;


    private final String carName;
    private int position = 0;
    private final NumberGenerator numberGenerator;

    public Car(String carName, NumberGenerator numberGenerator) {
        this.carName = carName;
        this.numberGenerator = numberGenerator;
    }

    public void moveByRandomNumber() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        int randomNumber = numberGenerator.generate();
        return randomNumber >= THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}