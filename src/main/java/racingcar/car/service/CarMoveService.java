package racingcar.car.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.car.model.Car;

public class CarMoveService {

    public void move(Car car) {
        Integer randomNumber = pickNumberInRange(0, 10);

        if (4 <= randomNumber) {
            car.increasePosition();
        }
    }

}
