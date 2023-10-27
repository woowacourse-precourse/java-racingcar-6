package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private String location = "";

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void run() {
        if (checkRunCondition()) {
            this.location = location + "-";
        }
    }

    private boolean checkRunCondition() {
        int runCondition = Randoms.pickNumberInRange(0,9);
        return runCondition >= 4;
    }

}
