package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;

    /**
     * Car 객체를 생성합니다.
     *
     * @param name 자동차의 이름입니다.
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * 자동차의 이름을 반환합니다.
     *
     * @return 자동차의 이름입니다.
     */
    public String getName() {
        return this.name;
    }

    /**
     * 자동차의 현재 위치를 반환합니다.
     *
     * @return 자동차의 현재 위치입니다.
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * 자동차의 위치를 이동시킵니다. 무작위 숫자가 4 이상일 경우 위치를 1 증가시킵니다.
     */
    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.position++;
        }
    }
}
