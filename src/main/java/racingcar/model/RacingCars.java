package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ErrorException;

public class RacingCars {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        validateRacingCars(racingCars);
        this.racingCars = racingCars;
    }

    public void checkEachCar() {
        racingCars.stream()
                .forEach(car -> car.move(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)));
    }

    public void checkEachCarWithNumber(int number) {
        racingCars.stream()
                .forEach(car -> car.move(number));
    }

    public List<Car> findWinner() {
        Car maxDistanceCar = findMaxDistanceCar();

        return racingCars.stream()
                .filter(car -> findSameDistanceCar(maxDistanceCar, car))
                .collect(Collectors.toList());
    }

    private boolean findSameDistanceCar(Car maxDistanceCar, Car otherCar) {
        return maxDistanceCar.isSameDistance(otherCar);
    }

    private void validateRacingCars(List<Car> racingCars) {
        List<String> racingCarNames = racingCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        hasDuplicatedNames(racingCarNames);
    }

    private void hasDuplicatedNames(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorException.DUPLICATED_NAMES.getErrorDescription());
        }
    }

    private Car findMaxDistanceCar() {
        return racingCars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalAccessError::new);
    }

    public List<Car> getRacingCars() {
        return new ArrayList<>(racingCars);
    }
}
