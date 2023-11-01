package racingcar.model.car;

import java.util.List;
import racingcar.exception.NoCarException;
import racingcar.model.car.dto.GameResult;
import racingcar.model.movepolicy.MovePolicy;
import racingcar.model.movepolicy.RandomMovePolicy;

public class Cars {
    private final static int MOVING_DISTANCE = 1;

    private final MovePolicy movePolicy = new RandomMovePolicy();
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(MOVING_DISTANCE, movePolicy);
        }
    }

    public List<String> getWinnerCars() {
        Car maxCar = getMaxCar();
        return cars.stream()
                .filter(maxCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }

    private Car getMaxCar() {
        return cars.stream()
                .reduce(Car::maxByPostion)
                .orElseThrow(() -> new NoCarException("등록된 자동차가 없습니다."));
    }

    public List<GameResult> generateGameResultList() {
        return cars.stream()
                .map(Car::generateGameResult)
                .toList();
    }
}
