package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;
    private final RandomNumberGenerator randomNumberGenerator;
    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (canMoveForward())
            this.position++;
    }

    private boolean canMoveForward() {
        return randomNumberGenerator.createRandomNumber() >= 4;
    }
}
