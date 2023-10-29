package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingCars;


import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {

    public void gameProgress(RacingCars racingCars) {
        for (Car car : racingCars.getCars()) {
            forwardCar(car);
        }
    }

    private void forwardCar(Car car) {
        if(forwardJudgment(createNumber())){
            car.forwardLocation();
        }
    }

    private boolean forwardJudgment(int number) {
        if(number >= 4) return true;
        return false;
    }

    private int createNumber() {
        return pickNumberInRange(0, 9);
    }

}
