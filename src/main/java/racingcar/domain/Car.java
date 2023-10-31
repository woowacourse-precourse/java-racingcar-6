package racingcar.domain;

import java.util.List;

public class Car { //자동차 객체를 관리한다.
    String carName;
    int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move(Car name){
        System.out.print(name.getCarName() + "움직입니다");
        this.distance += 1;
        System.out.println(name.getDistance());
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }
}
