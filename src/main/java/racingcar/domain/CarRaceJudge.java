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
        findCars.moveForwardWithAllCars(randomNumberSupplier.get());
    }

    public List<MoveResult> createSingleMoveResults() {
        Cars findCars = carsRepository.findCars();

        return findCars.cars()
                .stream()
                .map(MoveResult::createResultOf)
                .toList();
    }

    public List<String> findWinners() {
        Cars findCars = carsRepository.findCars();
        int winnerPosition = findWinnerPosition(findCars);

        return findCars.cars()
                .stream()
                .filter(car -> car.isWinner(winnerPosition))
                .map(Car::getName)
                .toList();
    }

    private int findWinnerPosition(final Cars cars) {
        return cars.cars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("우승자를 찾을 수 없습니다."));
    }
}
