package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int movedDist;

    public Car(String name) {
        this.name = name;
        movedDist = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (4 <= randomNumber) {
            movedDist++;
        }
    }
}
