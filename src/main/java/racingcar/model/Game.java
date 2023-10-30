package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.NoCarException;
import racingcar.model.dto.GameResult;
import racingcar.util.MoveResolver;

public class Game {
    private final int MOVING_DISTANCE = 1;
    private final MoveResolver moveResolver = new MoveResolver();
    private final List<Car> cars = new ArrayList<>();

    public void playRound() {
        for (Car car : cars) {
            car.move(MOVING_DISTANCE, moveResolver);
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

    public void enrollCars(List<String> carNames) {
        carNames.forEach(this::enrollCar);
    }

    private void enrollCar(String carName) {
        cars.add(new Car(carName));
    }
}
