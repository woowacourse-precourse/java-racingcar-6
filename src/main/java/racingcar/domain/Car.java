package racingcar.domain;

import racingcar.RandomNumberGenerator;

public class Car implements Comparable<Car> {

    private String name;
    private int position;
    private static final int MOVABLE_BOUND = 4;
    private static final int NAMING_LENGTH_BOUND = 5;

    public Car(String name) {

        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {

        if(name.length() > NAMING_LENGTH_BOUND) {
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
        return randomNumber >= MOVABLE_BOUND;
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
