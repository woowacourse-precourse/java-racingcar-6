package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

public class Car {
    private final static int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car makeCar(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber();
        return randomNumber >= MOVE_THRESHOLD;
    }
}
