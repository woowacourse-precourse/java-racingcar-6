package racingcar.domain;

import java.util.Objects;
import racingcar.util.CarGoingRandomNumber;
import racingcar.util.NumberGenerator;

public class Car {
    private final String name;
    private int position;
    private NumberGenerator numberGenerator;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
        this.numberGenerator = new CarGoingRandomNumber();
    }

    public void move() {
        int randomNumber = numberGenerator.generateRandomNumber(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= 4) {
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
        return position == car.position && Objects.equals(name, car.name) && Objects.equals(
                numberGenerator, car.numberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, numberGenerator);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", numberGenerator=" + numberGenerator +
                '}';
    }
}
