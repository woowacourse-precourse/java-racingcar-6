package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateRandomNum {

    public Integer createRanOneNum() {
        // 0에서 9까지의 정수 중 한 개의 정수 반환.
        return Randoms.pickNumberInRange(0, 9);
    }
}
