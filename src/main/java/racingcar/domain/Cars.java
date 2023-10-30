package racingcar.domain;


import static racingcar.exception.ErrorMessage.CANT_FIND_MAX_VALUE;

import java.util.List;
import racingcar.exception.RacingGameException;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> nameList) {

        return new Cars(nameList.stream()
                .map(Car::from)
                .toList());
    }

    public void goByRandomNumber() {
        cars.forEach(car -> car.go(RandomNumberGenerator.generate()));
    }

    public List<String> findWinnerNameList() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.isHere(maxPosition))
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> RacingGameException.of(CANT_FIND_MAX_VALUE));
    }

    public List<Car> getCars() {
        return cars;
    }

}
