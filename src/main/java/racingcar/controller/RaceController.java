package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private static final int RANGE_START_NUMBER = 0;
    private static final int RANGE_END_NUMBER = 9;
    private static final int MOVE_CRITERIA = 4;
    private static final String COMMA = ", ";

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANGE_START_NUMBER, RANGE_END_NUMBER);
    }

    private boolean isMoved() {
        if (getRandomNumber() >= MOVE_CRITERIA) {
            return true;
        }
        return false;
    }

    public void addRecord(Car car) {
        if (isMoved()) {
            car.addRecord();
        }
    }

    public String getNameAndRecord(List<Car> racingCars) {
        StringBuilder result = new StringBuilder();
        for (Car car : racingCars) {
            result.append(car.getNameAndRecord());
        }
        return result.toString();
    }

    private int getWinnerRecord(List<Car> racingCars) {
        int maxDistance = 0;

        for (Car car : racingCars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        return maxDistance;
    }

    private List<Car> findWinner(List<Car> racingCars) {
        List<Car> winner = new ArrayList<>();
        for (Car car : racingCars) {
            if (car.getDistance() == getWinnerRecord(racingCars)) {
                winner.add(car);
            }
        }
        return winner;
    }

    private boolean isWinnerMultiple(List<Car> winner) {
        return winner.size() >= 2;
    }

    private String getMultipleWinnerNames(List<Car> winner) {
        StringBuilder winnerNames = new StringBuilder();

        for (int i = 0; i < winner.size(); i++) {
            winnerNames.append(winner.get(i).getName());
            if (i == winner.size() - 1) {
                continue;
            }
            winnerNames.append(COMMA);
        }

        return winnerNames.toString();
    }

    private String getSingleWinnerName(List<Car> winner) {
        return winner.get(0).getName();
    }

    public String getWinnerName(List<Car> racingCars) {
        List<Car> winner = findWinner(racingCars);
        if (isWinnerMultiple(winner)) {
            return getMultipleWinnerNames(winner);
        }
        return getSingleWinnerName(winner);
    }
}
