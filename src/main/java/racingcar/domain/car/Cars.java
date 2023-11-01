package racingcar.domain.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.util.RandomGenerator;
import racingcar.view.input.error.InputError;
import racingcar.view.input.error.InputIllegalArgumentException;

public class Cars {

    private static final String CARS_ARE_EMPTY = "차가 존재하지 않습니다.";
    public static final String DISTANT_MARK = "-";

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        validateCanRace(carNames);

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private void validateCanRace(List<String> names) {
        if (names.size() < 2) {
            throw new InputIllegalArgumentException(InputError.NOT_EXCEED_MINIMUM_AMOUNT);
        }
    }

    public List<String> findWinners() {
        int maxDistance = findMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMaxDistance() {

        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(CARS_ARE_EMPTY));
    }

    public void randomCarMove(RandomGenerator randomGenerator) {
        cars.stream()
                .filter(car -> randomGenerator.isCanMove())
                .forEach(Car::moveCar);
    }

    public Map<String, String> generateCarStatus() {
        Map<String, String> carStatusMap = new HashMap<>();

        cars.forEach(car ->
                carStatusMap.put(car.getCarName(), generateStatusString(car.getDistance())));

        return carStatusMap;
    }

    private String generateStatusString(int distance) {
        return DISTANT_MARK.repeat(distance);
    }
}
