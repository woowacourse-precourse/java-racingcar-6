package racingcar.domain;

import racingcar.RandomNumberGenerator;

import java.util.Comparator;

public class Car implements Comparable<Car> {

    private Name name;
    private Position position;

    public Car(String name) {

        this.name = new Name(name);
        this.position = new Position();
    }

    public void play() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber();
        if(canMove(randomNumber)) {
            position.move();
        }
    }

    public boolean isSamePosition(Car other) {
        return this.position.getPosition() == other.position.getPosition();
    }

    @Override
    public int compareTo(Car other) {
        return this.position.getPosition() - other.position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }
}
