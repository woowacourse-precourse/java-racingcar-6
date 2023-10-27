package racingcar.model;

import racingcar.service.Accelerator;

//TODO: 허무맹랑할 수 있는 이야기이지만, 자동차 경주에 말이 들어온다면?? 해당 경우도 한번 고민해보기
public class Car implements Comparable<Car> {

    private static final String MARK = "-";

    private final String name;
    private Integer currentPosition;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.currentPosition = 0;
    }

    public void move() {
        if (Accelerator.canMoveForward()) {
            currentPosition++;
        }
    }


    //TODO: 게터 지양
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " : " + MARK.repeat(this.currentPosition);
    }

    private void validate(String value) {
        validateLength(value);
    }

    private void validateLength(String value) {
        if (1 > value.length() || value.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car car)) {
            return false;
        }
        return this.currentPosition.equals(car.currentPosition);
    }

    @Override
    public int compareTo(Car car) {
        return this.currentPosition - car.currentPosition;
    }
}
