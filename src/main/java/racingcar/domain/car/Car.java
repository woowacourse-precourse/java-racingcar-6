package racingcar.domain.car;

import racingcar.domain.car.move.Movement;

public class Car implements Comparable<Car> {
    private final String name;
    private final Movement position;

    public Car(String name, Movement position) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = position;
    }

    public void move() {
        position.move();
    }

    private Movement getPosition() {
        return position;
    }

    public void showName() {
        System.out.print(name);
    }

    @Override
    public int compareTo(Car car) {
        if(car == null) {
            throw new NullPointerException();
        }

        return getPosition().compareTo(car.getPosition());
    }

    @Override
    public String toString() {
        return name + " : " +  getPosition().toString();
    }
}
