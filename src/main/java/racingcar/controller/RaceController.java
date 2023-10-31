package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.constant.GameSettingCharacter;
import racingcar.constant.GameSettingNumber;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(GameSettingNumber.RANGE_START_NUMBER.get(),
                GameSettingNumber.RANGE_END_NUMBER.get());
    }

    private boolean isMoved() {
        return getRandomNumber() >= GameSettingNumber.MOVE_CRITERIA.get();
    }

    public void addRecord(Car car) {
        if (isMoved()) {
            car.addRecord();
        }
    }

    public String getNameAndRecord(List<Car> racingCars) {
        StringBuilder nameAndRecord = new StringBuilder();
        for (Car car : racingCars) {
            nameAndRecord.append(car.getNameAndRecord());
        }
        return nameAndRecord.toString();
    }

    private int getWinnerRecord(List<Car> racingCars) {
        int maxDistance = 0;

        for (Car car : racingCars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        return maxDistance;
    }

    private List<Car> findWinner(List<Car> racingCars) {
        int maxDistance = getWinnerRecord(racingCars);
        return racingCars.stream().filter(car -> car.getDistance() == maxDistance).collect(Collectors.toList());
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
            winnerNames.append(GameSettingCharacter.SEPARATOR_CHARACTER.get()).append(" ");
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
