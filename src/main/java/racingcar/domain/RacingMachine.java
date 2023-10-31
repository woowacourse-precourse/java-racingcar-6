package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingMachine {
    private List<Car> cars;
    private int playCount;

    public RacingMachine(List<Car> cars, int playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }

    public boolean canPlay() {
        return playCount > 0;
    }

    public void play() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generate());
        }
        playCount--;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxMoveCount = getMaxMoveCount();
        return getWinnersName(maxMoveCount);
    }

    private int getMaxMoveCount() {
        int maxMoveCount = 0;
        for (Car car : cars) {
            if(maxMoveCount < car.getMoveCount()) {
                maxMoveCount = car.getMoveCount();
            }
        }
        return maxMoveCount;
    }

    private List<String> getWinnersName(int maxMoveCount) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getMoveCount() == maxMoveCount) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

}
