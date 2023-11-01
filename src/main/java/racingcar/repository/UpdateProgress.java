package racingcar.repository;

import racingcar.domain.Car;

public class UpdateProgress {

    public void plusOrNot(Car car, boolean tOrF) {
        if (tOrF == true) car.progressPlusOne();
        //System.out.println(car.getName() + "의 프로그레스바 개수 : " + car.getProgressbar());
    }
}
