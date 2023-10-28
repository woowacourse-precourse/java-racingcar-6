package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    public static final int CAR_NAME_STANDARD_LENGTH = 5;
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        validate(racingCars);
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

    private void validate(List<Car> racingCars) {
        List<String> racingCarNames = racingCars.stream()
                .map(racingCar -> racingCar.getCarName())
                .collect(Collectors.toList());

        isOverStandardLength(racingCarNames);
        hasDuplicatedNames(racingCarNames);
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        racingCars.stream()
                .forEach(car -> carNames.add(car.getCarName()));
        return carNames;
    }

    private void isOverStandardLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_STANDARD_LENGTH) {
                throw new IllegalArgumentException("5글자가 넘어갔습니다");
            }
        }
    }

    private void hasDuplicatedNames(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다");
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
