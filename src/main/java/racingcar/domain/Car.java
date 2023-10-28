package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private Integer progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public void checkForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.progress += 1;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getProgress() {
        return progress;
    }
}
