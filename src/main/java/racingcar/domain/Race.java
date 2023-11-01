package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    private int getMaxProgress() {
        return cars.stream()
                .mapToInt(Car::getProgress)
                .max()
                .orElse(0);
    }

    public List<String> getWinners() {
        int maxProgress = getMaxProgress();
        return cars.stream()
                .filter(car -> car.isMaxProgress(maxProgress))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
