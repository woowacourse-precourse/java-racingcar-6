package racingcar.util;

public class Randoms {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    private Randoms() {
    }

    public static int getNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

}
