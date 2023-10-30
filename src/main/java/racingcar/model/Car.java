package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private Long movingCount;

    public Car(String name) {
        this.name = name;
        movingCount = 0L;
    }

    public void moveOrStay() {
        int decisionNumber = Randoms.pickNumberInRange(0, 9);

        if (decisionNumber >= 4) {
            movingCount++;
        }
    }
}