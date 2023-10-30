package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameMethods {
    /**
     * 난수 생성해서 배열에 저장
     *
     * @param numberOfCars
     * @return
     */
    public static int[] makeRandNum(int numberOfCars) {
        int[] howFar = new int[numberOfCars];
        for (int j = 0; j < numberOfCars; j++) {
            howFar[j] = Randoms.pickNumberInRange(0, 9);
        }
        return howFar;
    }

}
