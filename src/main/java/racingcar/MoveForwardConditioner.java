package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveForwardConditioner {
    private final int randomRangeStartNumber;
    private final int randomRangeEndNumber;

    public MoveForwardConditioner(
            int randomRangeStartNumber,
            int randomRangeEndNumber
    ) {
        this.randomRangeStartNumber = randomRangeStartNumber;
        this.randomRangeEndNumber = randomRangeEndNumber;
    }

    public boolean canMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(randomRangeStartNumber, randomRangeEndNumber);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}
