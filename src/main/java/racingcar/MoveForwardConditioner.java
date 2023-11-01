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

    /*
     * 랜덤 숫자가 4이상인 경우, 전진하고 (1로 표시), 아닐 경우 멈춘다(0으로 표시)
     * */
    public boolean canMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(randomRangeStartNumber, randomRangeEndNumber);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}
