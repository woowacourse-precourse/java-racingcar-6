package racingcar.domain;

import java.util.List;

public class Car { //자동차 객체를 관리한다.
    String carName;
    int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getDistance() {
        return distance;
    }
}
