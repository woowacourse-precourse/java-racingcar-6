package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final Set<Car> cars = new HashSet<>();

    public Cars(List<String> carNames) {
        this.cars.addAll(createCarsFromNames(carNames));
    }

    public int getSize() {
        return cars.size();
    }

    private Set<Car> createCarsFromNames(List<String> carNames) {
        Set<Car> carSet = carNames.stream().distinct()
                .map(name -> new Car(new Name(name))
                ).collect(Collectors.toSet());

        if (carNames.size() != carSet.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
        return carSet;
    }
}
