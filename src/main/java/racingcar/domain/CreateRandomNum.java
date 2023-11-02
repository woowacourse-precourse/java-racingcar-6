package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateRandomNum {
    private static final int START_RAN_NUM = 0;
    private static final int END_RAN_NUM = 9;

    /**
     * 0에서 9까지의 정수 중 한 개의 정수 반환.
     *
     * @return
     */
    public Integer createRanOneNum() {
        return Randoms.pickNumberInRange(START_RAN_NUM, END_RAN_NUM);
    }
}
