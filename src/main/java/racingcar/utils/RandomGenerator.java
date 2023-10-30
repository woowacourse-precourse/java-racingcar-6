package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

/*
 * Car랑 generateRandomNumber는 관련이 없는거 같아서 나누었습니다.
 * */
public class RandomGenerator {
    public int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
