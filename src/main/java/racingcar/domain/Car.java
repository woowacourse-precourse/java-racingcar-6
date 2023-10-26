package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public String name;
    public String forward;

    public Car(String name) {
        this.name = name;
        this.forward = "";
    }

    public String getName() {
        return name;
    }

    public String getForward() {
        return forward;
    }

    public boolean shouldCarMove() {

        int number = Randoms.pickNumberInRange(0, 9);
        return number >= 4;
    }
}
