package racingcar.domain;

import java.util.List;
import java.util.function.Supplier;
import racingcar.dto.MoveResult;

public class CarRaceJudge {

    private static final int START_POSITION = 0;
    private static final int MIN_ADDITION_NUMBER = 2;

    private final CarRepository carRepository = CarRepository.getInstance();

    public void addCars(final List<String> carNames) {
        carRepository.clearStore();
        validate(carNames);
        List<Car> cars = carNames.stream()
                .map(name -> Car.of(name, START_POSITION))
                .toList();
        carRepository.saveAll(cars);
    }

    public void moveCars(final Supplier<Integer> randomNumberGenerator) {
        List<Car> cars = carRepository.findAll();
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.get();
            car.moveForward(randomNumber);
        }
    }

    public List<MoveResult> createSingleMoveResults() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(MoveResult::createResultOf)
                .toList();
    }

    private void validate(final List<String> carNames) {
        validateDuplicate(carNames);
        validateCarCount(carNames);
    }

    private void validateDuplicate(final List<String> carNames) {
        if (isDuplicates(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateCarCount(final List<String> carNames) {
        if (carNames.size() < MIN_ADDITION_NUMBER) {
            throw new IllegalArgumentException("자동차는 2대 이상 등록해야 합니다");
        }
    }

    private boolean isDuplicates(final List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }
}
