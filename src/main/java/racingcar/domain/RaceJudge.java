package racingcar.domain;

import java.util.List;
import java.util.function.Supplier;
import racingcar.dto.MoveResult;

public class RaceJudge {

    private final CarsRepository carsRepository = CarsRepository.getInstance();

    public void addCars(final List<String> carNames) {
        Cars cars = Cars.from(carNames);
        carsRepository.save(cars);
    }

    public void moveCars(final Supplier<Integer> randomNumberSupplier) {
        Cars cars = findCarsObject();
        cars.moveAllForward(randomNumberSupplier);
    }

    public List<MoveResult> createSingleMoveResults() {
        Cars cars = findCarsObject();
        return cars.cars()
                .stream()
                .map(MoveResult::createResultFrom)
                .toList();
    }

    public List<String> findAllWinnerNames() {
        Cars cars = findCarsObject();
        return cars.findAllWinnerNames();
    }

    private Cars findCarsObject() {
        return carsRepository.findCars()
                .orElseThrow(() -> new IllegalArgumentException("자동차 경주에 참가할 자동차가 없습니다."));
    }
}
