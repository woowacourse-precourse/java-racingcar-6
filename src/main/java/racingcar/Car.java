package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
