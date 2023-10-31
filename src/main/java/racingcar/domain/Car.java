package racingcar.domain;

import racingcar.util.GenerateRandomNumber;

/**
 * 경기 자동차의 값들을 가진 domain
 */
public class Car {
    private String name;
    private int distance;

    /**
     * Car생성시 이름을 넣어야한다. 초기 distance는 0
     *
     * @param name 자동차 이름
     */
    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    /**
     * 해당 자동차의 이동거리 증가
     */
    public void move() {
        distance++;
    }

    /**
     * 해당 자동차의 이름 반환
     *
     * @return string 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 해당 자동차의 이동한 거리 반환
     *
     * @return 이동한 거리
     */
    public int getDistance() {
        return distance;
    }

    /**
     * 랜덤수를 받아 이동할 수 있는지 처리
     *
     * @return boolean 이동여부
     */
    public boolean isCanMove() {
        int random = GenerateRandomNumber.getRandomNumber();
        if (random >= 4) {
            return true;  //이동
        }
        return false; //이동하지 않기
    }
}
