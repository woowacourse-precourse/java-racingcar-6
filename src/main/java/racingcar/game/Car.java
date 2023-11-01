package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 자동차의 기능을 정의하는 클래스
 *
 * @author gemstoneyang
 */
public class Car {
    private final String name;
    private int distance;

    /**
     * @param name 자동차의 이름
     */
    Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    /**
     * 자동차의 움직임을 시도
     * <p>
     * 성공할 경우 거리 1 증가, 실패할 경우 거리 0 증가
     *
     */
    public void tryMove() {
        int number = Randoms.pickNumberInRange(0, 9);

        if (number >= 4) {
            this.distance++;
        }
    }

    @Override
    public String toString() {
        String result = this.name + " : " + "-".repeat(this.distance);

        return result.trim();
    }
}
