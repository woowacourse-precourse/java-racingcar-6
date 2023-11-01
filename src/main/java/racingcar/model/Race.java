package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Race {
    private final List<String> carNames;
    private Map<String, Car> cars = new HashMap<>();

    public Race(List<String> carNames) {
        this.carNames = carNames;
        for (String name : carNames) {
            cars.put(name, new Car(name));
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    private Car getCar(String carName) {
        return cars.get(carName);
    }

    public int getDistance(String carName) {
        return getCar(carName).getDistance();
    }

    private void randomAdvance(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.advance();
        }
    }

    public void doAttempt() {
        for (Car car : cars.values()) {
            randomAdvance(car);
        }
    }

    public List<String> getWinnerNames() {
        return carNames.stream()
                .collect(Collectors.groupingBy(
                        this::getDistance,
                        TreeMap::new,
                        Collectors.toList()))
                .lastEntry()
                .getValue();

    }
}
