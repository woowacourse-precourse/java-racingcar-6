package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateCarNamesSize(carNames);
        validateDuplicatedCarNames(carNames);
        cars = carNames.stream()
            .map(name -> new Car(name))
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void validateCarNamesSize(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차는 두 대 이상 입력해야 합니다.");
        }
    }

    public void validateDuplicatedCarNames(List<String> carNames) {
        HashMap<String, Integer> namesMap = new HashMap<>();
        for (String name : carNames) {
            namesMap.put(name, namesMap.getOrDefault(name, 0) + 1);
            if (namesMap.get(name) > 1) {
                throw new IllegalArgumentException("중복되는 이름이 있으면 안됩니다.");
            }
        }
    }
}
