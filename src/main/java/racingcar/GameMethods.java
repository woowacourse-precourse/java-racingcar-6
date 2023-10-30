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

    /**
     * 난수가 4 이상일 때 "-" 추가
     *
     * @param numberOfCars
     * @param movedDistance
     * @param howFar
     */
    public static void goOrStop(int numberOfCars, String[] movedDistance, int[] howFar) {
        for (int i = 0; i < numberOfCars; i++) {
            if (howFar[i] >= 4) {
                movedDistance[i] += "-";
            }
        }
    }
}
