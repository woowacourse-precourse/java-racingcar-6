package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingCars;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {

    private List<String> winnerList = new ArrayList<>();
    private int max = 0;

    public void gameProgress(RacingCars racingCars) {
        for (Car car : racingCars.getCars()) {
            forwardCar(car);
        }
    }

    public void getWinnerNames(RacingCars racingCars) {

        findMaxValue(racingCars);

        for (Car car : racingCars.getCars()) {
            findWinner(car);
        }

        racingCars.setWinners(winnerList);

    }

    private void forwardCar(Car car) {
        if (forwardJudgment(createNumber())) {
            car.forwardLocation();
        }
    }

    private boolean forwardJudgment(int number) {
        if (number >= 4) return true;
        return false;
    }

    private int createNumber() {
        return pickNumberInRange(0, 9);
    }

    private void findMaxValue(RacingCars racingCars) {
        for (Car car : racingCars.getCars()) {
            max = Math.max(car.getLocation(), max);
        }
    }

    private void findWinner(Car car) {
        if (max == car.getLocation()) winnerList.add(car.getName());
    }
}
