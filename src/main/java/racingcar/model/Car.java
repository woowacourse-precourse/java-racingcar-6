package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private String forwardMovementCount = "";

    public Car(String name) {
        this.name = name;
    }

    public void addForwardMovementCount() {
            forwardMovementCount += "-";
    }

    public int getForwardMovementCount() {
        return forwardMovementCount.length();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + forwardMovementCount;
    }

}
