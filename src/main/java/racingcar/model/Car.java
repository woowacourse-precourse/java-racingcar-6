package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static int carsNum;
    static int[] randomNumArray;

    public static void carRandomNum() {
        randomNumArray = new int[carsNum];

        for (int i = 0; i < carsNum; i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            randomNumArray[i] = randomNum;
        }
    }
}
