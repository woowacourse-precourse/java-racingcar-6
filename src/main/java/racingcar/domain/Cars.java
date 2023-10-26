package racingcar.domain;


import static racingcar.constant.RacingGameContant.CARS_SPLIT_STRING;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingGameException;

public class Cars {


    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String carNames) {

        return new Cars(Arrays.stream(carNames.split(CARS_SPLIT_STRING))
                .map(Car::from)
                .toList());

    }

    public void go() {
        cars.forEach(car -> car.go(RandomNumberGenerator.generate()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinnerNameList() {
        Integer maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.isHere(maxPosition))
                .map(Car::getName)
                .toList();
    }

    private Integer findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> RacingGameException.of(ErrorMessage.CANT_FIND_MAX_VALUE));
    }
}
