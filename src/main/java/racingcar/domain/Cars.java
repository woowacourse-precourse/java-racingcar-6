package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final String NO_CAR = "자동차가 존재하지 않습니다";
    private static final String NO_DUPLICATION_FOR_NAME = "자동차 이름은 중복될 수 없습니다";
    private static final String NO_WINNER = "우승 차가 존재하지 않습니다";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createByNames(List<CarName> carNames) {

        List<Car> cars = carNames.stream().map(Car::new).toList();

        validateDuplication(cars);
        validateExist(cars);

        return new Cars(cars);
    }

    private static void validateExist(List<Car> cars) {
        if (cars.size() == 0) {
            throw new IllegalArgumentException(NO_CAR);
        }
    }

    private static void validateDuplication(List<Car> cars) {
        Set<Car> removeDuplicatedCars = Set.copyOf(cars);

        if (removeDuplicatedCars.size() != cars.size()) {
            throw new IllegalArgumentException(NO_DUPLICATION_FOR_NAME);
        }
    }

    public void moveAll() {
        cars.forEach(car -> car.move(generateMoveSymbol()));
    }

    private int generateMoveSymbol() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<String> getWinningCarNames() {
        Car winnerCar = findWinnerCar();

        return cars.stream()
                .filter(car -> car.isEqualPosition(winnerCar))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private Car findWinnerCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(NO_WINNER));
    }

    public Map<String, Integer> getStatus() {
        Map<String, Integer> status = new LinkedHashMap<>();

        cars.forEach(car -> status.put(car.getCarName(), car.getPosition()));

        return status;
    }
}
