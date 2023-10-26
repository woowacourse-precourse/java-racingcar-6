package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Logics {
    public static String forwardOrNot () {
        int randomNumbers = Randoms.pickNumberInRange(0, 9);
        return randomNumbers >= 4 ? "-" : "";
    }

    public static String[] splitNames (String names) {
        return names.split(",");
    }

//    public static String winners (String[] names, String[] progress) {
//
//    }

}
