package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int JUDGE_CAN_GO_NUMBER = 4;
    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void rush() {
        location++;
    }

    public boolean canRush() {
        return Randoms.pickNumberInRange(1, 9) >= JUDGE_CAN_GO_NUMBER;
    }
}
