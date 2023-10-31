package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;


public class Car {
    String name;
    int movingCount;

    public Car(String carName, int count) {
        this.name = carName;
        this.movingCount = count;
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public void increaseMovingCount() {
        this.movingCount++;
    }

    public static boolean isMoved() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
