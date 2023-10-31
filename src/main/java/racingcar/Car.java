package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    protected StringBuilder distance = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StringBuilder getDistance() {
        return distance;
    }

    public void moveOnRandomChance() {
        int randomNumber = generateRandomNumber();
        if (isForward(randomNumber)) {
            distance.append("-");
        }
    }

    protected int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= 4;
    }
}
