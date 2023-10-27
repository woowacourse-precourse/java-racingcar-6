package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final int INITIAL_FORWARD_COUNT = 0;
    private static String carName;
    private static int forwardCount;

    public Car(String carName) {
        this.carName = carName;
        this.forwardCount = INITIAL_FORWARD_COUNT;
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void forwardCar(int randomNumber) {
        if (randomNumber >= 4) {
            forwardCount += 1;
        }
    }



}
