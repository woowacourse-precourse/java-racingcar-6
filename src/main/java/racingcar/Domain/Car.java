package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int currentPosition = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void runTrack() {
        if (getRandomNumber() >= 4) {
            currentPosition++;
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


}
