package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class JudgeMovement {
    public int[] createRandomNumbers(int carCount) {
        int[] randomNumbers = new int[carCount];
        for (int i = 0; i < carCount; i++) {
            randomNumbers[i] = Randoms.pickNumberInRange(0, 9);
        }
        return randomNumbers;
    }

    public void moveForward(int[] positions, int[] randomNumbers) {
        for (int i = 0; i < positions.length; i++) {
            if (randomNumbers[i] >= 4) {
                positions[i]++;
            }
        }
    }

}
