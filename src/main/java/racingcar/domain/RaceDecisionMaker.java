package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceDecisionMaker {
    public boolean raceDecision() {
        int randomNumber = pickNumber();
        return randomNumber >= 4;
    }

    private int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
