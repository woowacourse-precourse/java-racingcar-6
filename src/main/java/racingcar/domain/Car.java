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

    public void go(int movePoint) {
        if(isMove(movePoint)) {
            distance++;
        }
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isMove(int movePoint) {
        return movePoint >= 4;
    }
}
