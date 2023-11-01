package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.assertj.core.util.Sets;

public class Race {
    private final List<String> carNames;
    private final Map<String, Car> cars;

    public Race(List<String> carNames) {
        validateCarNames(carNames);

        this.carNames = carNames;
        cars = new HashMap<>();
        for (String name : carNames) {
            cars.put(name, new Car(name));
        }
    }

    private void validateCarNames(List<String> carNames) {
        Set<String> carNamesSet = Sets.newHashSet(carNames);
        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException("Duplicated names");
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
