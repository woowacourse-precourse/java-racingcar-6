package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car implements Comparable<Car> {

    private static final int MOVABLE_BOUND = 4;
    private Name name;
    private Position position;

    public Car(String name) {

        this.name = new Name(name);
        this.position = new Position();
    }

    public void play() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber();
        goOrStop(randomNumber);
    }

    public void goOrStop(int randomNumber) {
        if(isMovable(randomNumber)) {
            position.move();
        }
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber >= MOVABLE_BOUND;
    }

    @Override
    public int compareTo(Car other) {
        return this.position.compareTo(other.position);
    }

    public boolean isSamePosition(Car other) {
        return this.position.isSamePosition(other.position);
    }

    public String getName() {
        return name.getLawName();
    }

    public int getPosition() {
        return position.getLawPosition();
    }
}
