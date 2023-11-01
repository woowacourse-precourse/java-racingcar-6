package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private StringBuilder forward;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
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
