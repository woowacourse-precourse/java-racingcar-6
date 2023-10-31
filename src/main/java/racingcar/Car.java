package racingcar;

import camp.nextstep.edu.missionutils.Randoms;



public class Car {
    public String name;
    public int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    //전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++;
        }
    }
}
