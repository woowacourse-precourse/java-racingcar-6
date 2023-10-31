package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 랜덤 숫자 생성
 */
public class GenerateRandomNumber {
    /**
     * 생성한 랜덤숫자 반환 0~9
     *
     * @return int 랜덤숫자
     */
    public static int getRandomNumber() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random;
    }
}
