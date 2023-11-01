package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceDecisionMaker {
    public static boolean raceDecision() {
        int randomNumber = pickNumber();
        return randomNumber >= 4;
    }

    public static int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
