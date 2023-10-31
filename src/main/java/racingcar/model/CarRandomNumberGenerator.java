package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * CarRandomNumberGenerator 클래스는 RandomNumberGenerator의 구현체다.
 * 정적 팩토리 메서드를 이용해 구현하여 하나의 인스턴스만 사용되게했다.
 * 인스턴스를 사용하기 위해서는 public static CarRandomNumberGenerator getInstance()를 호출해야한다.
 */
public class CarRandomNumberGenerator implements RandomNumberGenerator {
    private static final int RANDOM_START_INCLUSIVE = 1;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final CarRandomNumberGenerator CAR_RANDOM_NUMBER_GENERATOR =
            new CarRandomNumberGenerator();

    /**
     * 외부에서 객체를 생성할 수 없게함
     */
    private CarRandomNumberGenerator() {
    }

    /**
     * 인스턴스를 새로 만들지 않고 리턴
     *
     * @return CarRandomNumberGenerator 인스턴스
     */
    public static CarRandomNumberGenerator getInstance() {
        return CAR_RANDOM_NUMBER_GENERATOR;
    }

    /**
     * 1 ~ 9의 랜덤값을 리턴한다.
     *
     * @return 1 ~ 9 사이의 정수
     */
    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }
}
