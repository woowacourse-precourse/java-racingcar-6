package racingcar.domain;

import java.util.List;
import java.util.function.Supplier;
import racingcar.dto.MoveResult;

public class CarRaceJudge {

    private final CarsRepository carsRepository = CarsRepository.getInstance();

    public void addCars(final List<String> carNames) {
        ParticipatingCars cars = ParticipatingCars.from(carNames);
        carsRepository.save(cars);
    }

    public void moveCars(final Supplier<Integer> randomNumberSupplier) {
        ParticipatingCars cars = carsRepository.findCars();
        cars.moveAllForward(randomNumberSupplier);
    }

    public List<MoveResult> createSingleMoveResults() {
        ParticipatingCars cars = carsRepository.findCars();
        return cars.cars()
                .stream()
                .map(MoveResult::createResultFrom)
                .toList();
    }

    public List<String> findAllWinnerNames() {
        ParticipatingCars cars = carsRepository.findCars();
        return cars.findAllWinnerNames();
    }
}
