package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    //현재 자동차의 이동거리 변수
    private int distance;

    //자동차의 이름
    private String name;

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    //자동차 객체 생성자
    Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    //0~9랜덤값 가져오기
    public void count_Random() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            distance += 1;
        }
    }
}
