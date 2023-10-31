package racingcar.services;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceRoundSimulator {




    private static int generateZeroToNineRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static boolean goForward() {
        return generateZeroToNineRandomValue() >= 4;
    }

}
