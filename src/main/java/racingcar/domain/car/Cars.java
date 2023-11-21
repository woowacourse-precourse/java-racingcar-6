package racingcar.domain.car;

import java.util.List;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.exception.RacingException;

public class Cars {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Cars(List<String> carNames, NumberGenerator numberGenerator) {
        validateCars(carNames);
        cars = carNames.stream()
                .map(Car::new)
                .toList();
        this.numberGenerator = numberGenerator;
    }

    private void validateCars(List<String> carNames) {
        validateNotEmpty(carNames);
        validateNotDuplicated(carNames);
    }

    private void validateNotDuplicated(List<String> carNames) {
        int distinctSize = (int) carNames.stream()
                .distinct()
                .count();
        if (distinctSize != carNames.size()) {
            throw RacingException.DUPLICATE_CARS_NAME.makeException();
        }
    }

    private void validateNotEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw RacingException.NO_CAR_FOUNDED.makeException();
        }
    }

    public void move() {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinner() {
        int winnersPosition = getWinnersPosition();
        return cars.stream()
                .filter(car -> car.at(winnersPosition))
                .map(Car::getName)
                .toList();
    }

    private int getWinnersPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
