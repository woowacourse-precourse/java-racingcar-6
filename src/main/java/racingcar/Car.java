package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int advance;

    public Car(String name, int advance) {
        this.name = name;
        this.advance = advance;
    }

    public String getName() {
        return name;
    }

    public int getAdvance() {
        return advance;
    }

    public void go() {
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            advance++;
    }
}
