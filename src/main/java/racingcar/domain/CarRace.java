package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRace {
    public static String printTrack() {
        int number = Randoms.pickNumberInRange(0, 9);

        if (number >= 4) {
            return "-";
        } else {
            return "";
        }
    }
}
