package racingcar.domain;

import racingcar.utils.NumberGenerator;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(NumberGenerator numberGenerator) {
        final int pressStrength = numberGenerator.press();
        if (pressStrength >= 4) {
            this.position++;
        }
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position - otherCar.position;
    }

    public boolean isSamePosition(Car otherCar) {
        return this.position == otherCar.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
