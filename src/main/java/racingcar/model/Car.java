package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private String name;
    private List<String> currentLocation;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.currentLocation = new ArrayList<>();
    }

    public int currentLocation() {
        return this.currentLocation.size();
    }

    public void forwardCar() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            currentLocation.add("-");
        }
    }

    public void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + " : " + String.join("", this.currentLocation);
    }

}
