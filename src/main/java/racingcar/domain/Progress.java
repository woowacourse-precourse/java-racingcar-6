package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Progress {
    private static final Integer SUCCESS_THRESHOLD = 4;
    private static final Integer MINIMUM_RANGE_NUMBER = 0;
    private static final Integer MAXIMUM_RANGE_NUMBER = 9;
    private static final Integer SUCCESS = 1;
    private static final Integer FAIL = 0;

    private final boolean progressStatus;

    private Progress() {
        this.progressStatus = getProgressStatus();
    }

    public static Progress create() {
        return new Progress();
    }

    public Integer getScore() {
        if (progressStatus) {
            return SUCCESS;
        }
        return FAIL;
    }

    private boolean getProgressStatus() {
        final int number = Randoms.pickNumberInRange(MINIMUM_RANGE_NUMBER, MAXIMUM_RANGE_NUMBER);
        return number >= SUCCESS_THRESHOLD;
    }
}