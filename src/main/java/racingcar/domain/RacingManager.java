package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import racingcar.exception.BusinessException;
import racingcar.exception.ExceptionCode;
import racingcar.service.dto.GameResult;
import racingcar.view.dto.CarNameList;

public class RacingManager {

    private final List<Car> cars;

    public RacingManager(CarNameList carNameList) {
        this.cars = carNameList.stream()
                .map(Car::new)
                .toList();
    }

    public void moveEachCar(List<Integer> randomNumbers) {
        validate(randomNumbers.size());
        int size = size();
        for (int i = 0; i < size; i++) {
            cars.get(i)
                    .move(
                            randomNumbers.get(i)
                    );
        }
    }

    private void validate(int randomNumberSize) {
        if (randomNumberSize != size()) {
            throw new BusinessException(
                    ExceptionCode.INVALID_RANDOM_NUMBERS_SIZE,
                    this.getClass()
            );
        }
    }

    public int size() {
        return cars.size();
    }

    public List<String> calculateWinner() {
        int maxDistance = getMaxDistance();
        return cars
                .stream()
                .filter(c ->
                        c.getDistance() == maxDistance
                )
                .map(Car::getName)
                .toList();
    }

    private int getMaxDistance() {
        int zero = 0;
        Optional<Integer> maxDistance = cars.stream()
                .max(Comparator.comparing(Car::getDistance))
                .map(Car::getDistance);
        return maxDistance.orElse(zero);

    }

    public GameResult createResult() {
        GameResult result = new GameResult();
        cars.forEach(result::note);
        return result;
    }
}
