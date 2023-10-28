package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ErrorException;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        validateRacingCars(racingCars);
        this.racingCars = racingCars;
    }

    public void checkEachCar() {
        racingCars.stream()
                .forEach(car -> car.move(Randoms.pickNumberInRange(0,9)));
    }

    public void checkEachCarWithNumber(int number) {
        racingCars.stream()
                .forEach(car -> car.move(number));
    }

    public List<Car> findWinner() {
        List<Car> winnerCars = new ArrayList<>();
        Car maxDistanceCar = findMaxDistanceCar();

        racingCars.stream()
                .filter(car -> maxDistanceCar.getDistance() == car.getDistance())
                .forEach(winner -> winnerCars.add(winner));

        return winnerCars;
    }

    private void validateRacingCars(List<Car> racingCars) {
        List<String> racingCarNames = racingCars.stream()
                .map(racingCar -> racingCar.getCarName())
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
