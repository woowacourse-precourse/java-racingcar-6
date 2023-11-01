package racingcar.repository;

import racingcar.domain.Car;

public class UpdateProgress {

    public void plusOrNot(Car car, boolean tOrF) {
        System.out.println("plusOrNot");
        if (tOrF == true) car.progressPlusOne();
    }
}
