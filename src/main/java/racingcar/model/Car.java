package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static int[] carRandomNum(int carsNum) {
        int[] randomNumArray = new int[carsNum];

        for (int j = 0; j < carsNum; j++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            randomNumArray[j] = randomNum;
        }

        return randomNumArray;
    }

    public static int[] carMore4()
}
