package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Dice {
    private final static int BASE_LINE_FOR_JUDGE_SUCCESS = 4;
    private final static int MINIMUM_NUMBER_FOR_PICK_NUMBER = 0;
    private final static int MAXIMUM_NUMBER_FOR_PICK_NUMBER = 9;

    private Dice() {
    }

    public static boolean isSuccess() {
        return (getRandomNumber() >= BASE_LINE_FOR_JUDGE_SUCCESS);
    }

    private static int getRandomNumber() {
        return pickNumberInRange(MINIMUM_NUMBER_FOR_PICK_NUMBER, MAXIMUM_NUMBER_FOR_PICK_NUMBER);
    }
}
