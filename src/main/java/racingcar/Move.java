package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Move {

    public static void moveForward(int carQuantity, int[] positions) {
        for (int j = 0; j < carQuantity; j++) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            isForward(positions, j, randomValue);
        }
    }

    private static void isForward(int[] positions, int j, int randomValue) {
        if (randomValue >= 4) {
            positions[j]++;
        }
    }
}
