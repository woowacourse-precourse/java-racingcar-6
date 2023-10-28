package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        //0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우에 자동차는 전진한다.
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            position++;
        }
    }

    public void showCar() {

    }
}
