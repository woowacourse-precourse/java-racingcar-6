package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingCars;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {

    private List<String> winnerList = new ArrayList<>();
    private int maxDistance = 0;
    private static final int MIN_FORWARD_THRESHOLD = 4;


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
        return number >= MIN_FORWARD_THRESHOLD;
    }

    private int createNumber() {
        return pickNumberInRange(0, 9);
    }

    private void findMaxValue(RacingCars racingCars) {
        for (Car car : racingCars.getCars()) {
            maxDistance = Math.max(car.getLocation(), maxDistance);
        }
    }

    private void findWinner(Car car) {
        if (maxDistance == car.getLocation()) winnerList.add(car.getName());
    }
}