package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

/*
 * Car 랑 generateRandomNumber 는 관련이 없는거 같아서 나누었습니다.
 * */
public class RandomGenerator implements NumberGenerator{
    private int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    @Override
    public int generateNumber(int min, int max) {
        return generateRandomNumber(min, max);
    }
}
