package racingcar.model;

import java.util.List;
import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;
import racingcar.dto.response.CarInfo;
import racingcar.dto.response.RacingStatus;
import racingcar.dto.response.WinnerNames;
import racingcar.exception.IllegalRacingStatusException;

public class Racing {

    private final List<Car> cars;
    private final Integer maxTryCount;
    private Integer currentTryCount;

    private Racing(List<Car> cars, Integer maxTryCount) {
        this.cars = cars;
        this.maxTryCount = maxTryCount;
        this.currentTryCount = 0;
    }

    public static Racing of(CarNames carNames, TryCount tryCount, NumberGenerator numberGenerator) {
        return new Racing(carNames.getNames().stream()
            .map(name -> new Car(name, numberGenerator)).toList(),
            tryCount.getCount());
    }

    public void race() {
        if (isFinished()) {
            throw new IllegalRacingStatusException();
        }
        cars.forEach(car -> car.tryMove());
        currentTryCount++;
    }

    public List<String> getWinningCarNames() {
        if (!isFinished()) {
            throw new IllegalRacingStatusException();
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

    public Integer getMaxTryCount() {
        return maxTryCount;
    }

    public Integer getCurrentTryCount() {
        return currentTryCount;
    }

    public Boolean isFinished() {
        return maxTryCount == currentTryCount;
    }

    private Integer getMaxMoveCount() {
        return cars.stream().mapToInt(Car::getMoveCount).max().getAsInt();
    }
}
