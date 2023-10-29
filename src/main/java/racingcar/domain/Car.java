package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void triesToMove() {
        int power = Randoms.pickNumberInRange(0, 9);
        if (power >= 4) {
            move();
        }
    }

    public boolean isLocatedIn(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - this.getPosition();
    }
}
