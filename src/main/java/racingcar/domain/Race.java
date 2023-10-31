package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.constants.NumberConstants;

public class Race {
    private List<Car> cars;
    private int tryCount;

    public Race(List<Car> cars, int tryCount) {
        this.cars = new ArrayList<>(cars);
        this.tryCount = tryCount;
    }

    public void startOfRace() {
        assignRandomValuesForEachCar();
    }

    private void assignRandomValuesForEachCar() {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(NumberConstants.MIN_RANGE, NumberConstants.MAX_RANGE);
            car.judgmentCarMove(random);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxProgress = getMaxProgress();
        for (Car car : cars) {
            if (car.isMaxProgress(maxProgress)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxProgress() {
        int maxProgress = 0;
        for (Car car : cars) {
            if (car.isMoreProgress(maxProgress)) {
                maxProgress = car.getProgress();
            }
        }
        return maxProgress;
    }
}
