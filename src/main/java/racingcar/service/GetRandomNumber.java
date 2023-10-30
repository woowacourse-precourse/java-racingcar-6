package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.consts.ConstString.MIN_RANDOM_SIZE;
import static racingcar.consts.ConstString.MAX_RANDOM_SIZE;

public class GetRandomNumber {
    public int getRandomNum() {
        return Randoms.pickNumberInRange(MIN_RANDOM_SIZE, MAX_RANDOM_SIZE);
    }
}
