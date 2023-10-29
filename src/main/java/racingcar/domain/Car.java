package racingcar.domain;

import racingcar.RandomNumberGenerator;

import java.util.Comparator;

public class Car implements Comparable<Car> {

    private String name;
    private int position;

    public Car(String name) {

        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {

        if(name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber();
        if(canMove(randomNumber)) {
            position++;
        }
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
