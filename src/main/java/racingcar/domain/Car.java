package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Car implements Comparable<Car> {
    private String name;
    private int position;


    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int moveCount) {
        this.position = moveCount;
    }
    @Override
    public int compareTo(Car c) {
        return c.position - this.position;
    }
}
