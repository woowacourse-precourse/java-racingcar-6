package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * <p>랜덤 숫자 생성을 도와주는 유틸리티 클래스입니다.</p>
 *
 * <p>이 클래스는 {@link camp.nextstep.edu.missionutils.Randoms} 라이브러리를 활용하여
 * 지정된 범위 내의 랜덤 숫자를 생성하는 기능을 제공합니다.</p>
 */
public class RandomGenerator {

    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;

    /**
     * <p>{@link #MIN_BOUND}와 {@link #MAX_BOUND} 사이의 랜덤 정수를 반환합니다.</p>
     *
     * <p>이 메서드는 {@link camp.nextstep.edu.missionutils.Randoms#pickNumberInRange(int, int)}를 사용하여
     * 지정된 범위 내의 랜덤 숫자를 생성하고 반환합니다.</p>
     *
     * @return {@link #MIN_BOUND}와 {@link #MAX_BOUND} 사이의 랜덤 정수
     */
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }
}
