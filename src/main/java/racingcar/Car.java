package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int count;
    private final String name;

    public Car(String inputName) {
        count = 0;
        name = inputName;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void move() {
        count++;
    }

}
