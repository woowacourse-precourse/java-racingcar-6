package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private final RandomNumberGenerator randomNumberGenerator;
    public Car(String name, RandomNumberGenerator randomNumberGenerator, int position) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (canMoveForward())
            this.position++;
    }

    private boolean canMoveForward() {
        return randomNumberGenerator.createRandomNumber() >= 4;
    }
}
