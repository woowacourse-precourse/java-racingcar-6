package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Progress {
    public static final Integer SUCCESS_THRESHOLD = 4;
    public static final Integer MINIMUM_RANGE_NUMBER = 0;
    public static final Integer MAXIMUM_RANGE_NUMBER = 9;
    public static final Integer SUCCESS = 1;
    public static final Integer FAIL = 0;

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