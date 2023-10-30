package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createByNames(List<CarName> carNames) {

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        validateDuplication(cars);
        validateExist(cars);

        return new Cars(cars);
    }

    private static void validateExist(List<Car> cars) {
        if (cars.size() == 0) {
            throw new IllegalArgumentException("자동차가 존재하지 않습니다");
        }
    }

    private static void validateDuplication(List<Car> cars) {
        Set<Car> removeDuplicatedCars = Set.copyOf(cars);

        if (removeDuplicatedCars.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다");
        }
    }

    public Map<String, Integer> goForward() {
        Map<String, Integer> status = new LinkedHashMap<>();

        cars.forEach(car -> {
            car.goForward(Randoms.pickNumberInRange(0, 9));
            status.put(car.getCarName(), car.getPosition());
        });

        return status;
    }

    public List<String> getWinningCarNames() {
        Car winnerCar = cars.stream().max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("우승 차가 존재하지 않습니다"));

        return cars.stream()
                .filter(car -> car.isEqualPosition(winnerCar))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
