package racingcar.model;

import java.util.List;
import racingcar.dto.CarInfo;
import racingcar.dto.CarNames;
import racingcar.dto.RacingStatus;
import racingcar.dto.TryCount;
import racingcar.dto.WinnerNames;

public class Racing {

    private final List<Car> cars;
    private final Integer maxTryCount;
    private Integer currentTryCount;

    private Racing(List<Car> cars, Integer maxTryCount) {
        this.cars = cars;
        this.maxTryCount = maxTryCount;
        this.currentTryCount = 0;
    }

    public static Racing of(CarNames carNames, TryCount tryCount) {
        return new Racing(carNames.getNames().stream().map(Car::new).toList(), tryCount.getCount());
    }

    public void race() {
        if (isFinished()) {
            throw new IllegalStateException();
        }
        cars.forEach(car -> car.randomGoForward());
        currentTryCount++;
    }

    public List<String> getWinningCarNames() {
        if (!isFinished()) {
            throw new IllegalStateException();
        }
        Integer maxCount = getMaxMoveCount();
        return cars.stream().filter(car -> maxCount.equals(car.getMoveCount())).map(Car::getName)
            .toList();
    }

    public WinnerNames getWinnerNames() {
        return WinnerNames.of(this);
    }

    public List<CarInfo> getCarInfoList() {
        return cars.stream().map(CarInfo::from).toList();
    }

    public RacingStatus getRacingStatus() {
        return RacingStatus.from(this);
    }

    public Boolean isFinished() {
        return maxTryCount == currentTryCount;
    }

    private Integer getMaxMoveCount() {
        return cars.stream().mapToInt(Car::getMoveCount).max().getAsInt();
    }
}
