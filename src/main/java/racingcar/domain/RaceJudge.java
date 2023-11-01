package racingcar.domain;

import java.util.List;
import java.util.function.Supplier;
import racingcar.dto.MoveResults;
import racingcar.dto.WinnerNames;

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

    public MoveResults createSingleMoveResults() {
        Cars cars = findCarsObject();
        return MoveResults.from(cars);
    }

    public WinnerNames findAllWinnerNames() {
        Cars cars = findCarsObject();
        return WinnerNames.from(cars);
    }

    private Cars findCarsObject() {
        return carsRepository.findCars()
                .orElseThrow(() -> new IllegalArgumentException("자동차 경주에 참가할 자동차가 없습니다."));
    }
}
