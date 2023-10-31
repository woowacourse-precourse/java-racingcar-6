package racingcar.domain;

import java.util.Objects;

public class Car {
    private final NickName nickName;
    private Position position;

    public Car(final String nickName) {
        this(nickName, 0);
    }

    public Car(final String nickName, int position) {
        this.nickName = new NickName(nickName);
        this.position = new Position(position);
    }

    public String getNickName() {
        return nickName.toString();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position = position.move();
        }
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
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
        return Objects.equals(nickName, car.nickName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "nickName='" + nickName + '\'' +
                ", position=" + position +
                '}';
    }
}
