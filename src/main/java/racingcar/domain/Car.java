package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int distance = 0;

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void go() {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++;
        }
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
