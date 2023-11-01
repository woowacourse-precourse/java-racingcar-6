package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

// 자동차 (Car 클래스) : 자동차의 움직임과 상태를 관리
// getName() : private로 선언된 이름을 쓰기위한 역할
// getDistance() : private로 선언된 거리을 쓰기위한 역할
// move() : 자동차 전진하는 역할 (0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상)

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    //전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++;
        }
    }
    public String getName() {
        return name;
    } // 이름

    public int getDistance() {
        return distance;
    } // 거리정보
}
