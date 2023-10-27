package racingcar.domain;

import java.util.List;
import java.util.function.Supplier;
import racingcar.dto.MoveResult;

public class CarRaceJudge {

    private final CarsRepository carsRepository = CarsRepository.getInstance();

    public void addCars(final List<String> carNames) {
        Cars cars = Cars.from(carNames);
        carsRepository.save(cars);
    }

    public void moveCars(final Supplier<Integer> randomNumberSupplier) {
        Cars findCars = carsRepository.findCars();
        findCars.moveAllForward(randomNumberSupplier);
    }

    public List<MoveResult> createSingleMoveResults() {
        Cars findCars = carsRepository.findCars();
        return findCars.cars()
                .stream()
                .map(MoveResult::createResultFrom)
                .toList();
    }

    public List<String> findWinners() {
        Cars findCars = carsRepository.findCars();
        return findCars.findWinners();
    }
}
