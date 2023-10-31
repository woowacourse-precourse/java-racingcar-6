package racingcar.model;

import racingcar.system.util.RandomNumberGenerator;

import java.util.Objects;

public class Car {
    private static final int MOVEMENT_CONDITION = 4;
    private static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;
    private RandomNumberGenerator randomNumberGenerator;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
        this.setRandomNumberGenerator(new RandomNumberGenerator());
    }

    public void startEngine() {
        int generatedNumber = randomNumberGenerator.generate();
        if (generatedNumber >= MOVEMENT_CONDITION) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return getPosition() == car.getPosition() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }
}
