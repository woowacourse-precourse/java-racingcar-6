package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RoundPlaying {

    boolean decideToMove (int randomNumber) {
        return randomNumber >= 4;
    } // randomNumber 가 4 이상이면 true 반환

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
