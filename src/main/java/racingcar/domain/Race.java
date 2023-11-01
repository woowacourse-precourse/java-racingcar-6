package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constants.MessageConstants;
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

    private Car getMaxProgressCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(MessageConstants.EMPTY_CAR_LIST));
    }

    public List<String> getWinners() {
        final Car maxProgressCar = getMaxProgressCar();
        return findSameProgressCars(maxProgressCar);
    }

    private List<String> findSameProgressCars(Car maxProgressCar) {
        return cars.stream()
                .filter(maxProgressCar::isSameProgress)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}