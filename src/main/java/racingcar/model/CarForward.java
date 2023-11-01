package racingcar.model;

import static racingcar.model.Car.carsNum;
import static racingcar.model.Car.randomNumArray;

public class CarForward {
    static StringBuilder[] forwardCount = new StringBuilder[carsNum];
    static int[] forwardCountInt = new int[carsNum];

    public static void forwardCountInit() {
        for (int l = 0; l < carsNum; l++) {
            forwardCount[l] = new StringBuilder();
        }
    }

    public static void carMoreThanFour() {
        for (int k = 0; k < carsNum; k++) {
            if (randomNumArray[k] >= 4) {
                forwardCount[k].append("-");
                forwardCountInt[k]++;
            }
        }
    }
}
