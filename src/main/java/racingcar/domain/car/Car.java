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

    public void appendCarName(StringBuilder sb) {
        sb.append(name);
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    public String toProgress() {
        return name + " : " +  position.toStringBar();
    }
}
