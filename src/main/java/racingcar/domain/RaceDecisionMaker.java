package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

/** 랜덤값을 생성하여 전진할지를 결정 */
public class RaceDecisionMaker {
    public static boolean raceDecision() {
        int randomNumber = pickNumber();
        return randomNumber >= 4;
    }

    public static int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
