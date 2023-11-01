package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++; // NumberValidator 검증을 통해서 Integer.MAX_VALUE 이하임을 보장한다.
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
