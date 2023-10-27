package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Constants;

/*
 * Car랑 generateRandomNumber는 관련이 없는거 같아서 나누었습니다.
 * */
public class RandomGenerator {
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_NUMBER.getIntValue(), Constants.MAX_NUMBER.getIntValue());
    }
}
