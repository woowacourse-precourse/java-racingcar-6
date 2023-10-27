package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Constants;

public class Car {
    private String name;
    private final StringBuilder distance;

    public Car(String name) {
        this.name = name;
        this.distance = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void moveForward() {
        if (generateRandomNumber() >= Constants.STANDARD_NUMBER.getIntValue())
            distance.append("-");
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_NUMBER.getIntValue(), Constants.MAX_NUMBER.getIntValue());
    }
}
