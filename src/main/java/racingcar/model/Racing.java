package racingcar.model;

import java.util.List;
import racingcar.dto.CarInfo;
import racingcar.dto.RacingStatus;

public class Racing {

    private final List<Car> cars;

    private Racing(List<Car> cars) {
        this.cars = cars;
    }

    public static Racing makeRacingByCarNames(List<String> carNames) {
        return new Racing(carNames.stream().map(Car::new).toList());
    }

    public void tryCarsMoveForward() {
        cars.forEach(car -> car.randomGoForward());
    }

    public List<String> getWinningCarNames() {
        Integer maxCount = getMaxMoveCount();
        return cars.stream().filter(car -> car.getMoveCount() == maxCount).map(Car::getName)
            .toList();
    }

    public List<CarInfo> getCarInfoList() {
        return cars.stream().map(CarInfo::from).toList();
    }

    public RacingStatus getRacingStatus() {
        return RacingStatus.from(this);
    }

    private Integer getMaxMoveCount() {
        return cars.stream().mapToInt(Car::getMoveCount).max().getAsInt();
    }
}
