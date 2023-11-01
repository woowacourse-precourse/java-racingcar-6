package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private StringBuilder forward;

    public Car(String name) {
        this.name = name;
        forward = new StringBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getForward() {
        return this.forward.toString();
    }

    public void setForward() {
        this.forward.append("-");
    }

    public int setRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
