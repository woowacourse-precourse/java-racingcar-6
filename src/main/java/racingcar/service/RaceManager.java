package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Constants;
import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceManager {

    private final List<Car> cars;

    public RaceManager(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void startRace(int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(Constants.RANDOM_MIN_RANGE.getValue(), Constants.RANDOM_MAX_RANGE.getValue());
            car.move(randomNumber);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int max = -1;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }
}