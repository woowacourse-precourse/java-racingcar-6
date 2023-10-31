package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateRandomNum {
    private static final int START_NUM = 0;
    private static final int END_NUM = 9;

    /**
     * 0에서 9까지의 정수 중 한 개의 정수 반환.
     *
     * @return
     */
    public Integer createRanOneNum() {
        return Randoms.pickNumberInRange(START_NUM, END_NUM);
    }
}
