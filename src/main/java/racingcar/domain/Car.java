package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private String progress;

    public Car(String name) {
        this.name = name;
        this.progress = "";
    }

    public void forward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.progress += "-";
        }
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }
}
