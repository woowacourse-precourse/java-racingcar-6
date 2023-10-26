package racingcar.module;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

    static final int STOP_THRESHOLD = 3;
    String name;
    int pos;

    public Car(String name) {
        this.name = name;
        this.pos = 0;
    }

    public boolean isAtSamePos(Car car) {
        return this.pos == car.pos;
    }

    public void turnAction() {
        if (Randoms.pickNumberInRange(0, 9) > STOP_THRESHOLD) {
            move();
        }
    }

    void move() {
        this.pos++;
    }

    public int getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.pos, car.pos);
    }
}
