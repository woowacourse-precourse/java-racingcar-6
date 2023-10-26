package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {

    public void forwardOrNot(List<Car> cars) {

        for (Car car : cars) {
            if (car.shouldCarMove()) {
                car.forward += "-";
            }
            System.out.println(car.getName() + " : " + car.getForward());
        }
        System.out.println(" ");
    }

    public void startRace(List<Car> cars, int moveCount) {

        for (int i = 0; i < moveCount; i++) {
            forwardOrNot(cars);
        }
    }
}
