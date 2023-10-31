package racingcar.domain;


import static racingcar.exception.ErrorMessage.CANT_FIND_MAX_VALUE;

import java.util.Comparator;
import java.util.List;
import racingcar.exception.RacingGameException;

public class Cars {
    private final NumberGenerator numberGenerator;
    private final List<Car> cars;

    private Cars(final List<Car> cars, final NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static Cars of(final List<String> nameList, final NumberGenerator numberGenerator) {

        return new Cars(nameList.stream()
                .map(Car::from)
                .toList(), numberGenerator);
    }

    public void goByNumber() {
        cars.forEach(car -> car.go(numberGenerator.generate()));
    }

    public List<String> findWinnerNameList() {
        Position maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.isHere(maxPosition))
                .map(Car::getNameString)
                .toList();
    }

    private Position findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(Position::getPosition))
                .orElseThrow(() -> RacingGameException.of(CANT_FIND_MAX_VALUE));
    }

    public List<Car> getCars() {
        return cars;
    }

}
