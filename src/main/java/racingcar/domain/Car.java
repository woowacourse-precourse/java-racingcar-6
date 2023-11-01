package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int THRESHOLD_NUMBER = 4;

    private String name;
    private static int position = 0;

    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void drive() {
        int number = randomNumberGenerator.makeRandomNumber();

        if (number >= THRESHOLD_NUMBER) {
            position++;
        }
    }

    public String showCarPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }
}
