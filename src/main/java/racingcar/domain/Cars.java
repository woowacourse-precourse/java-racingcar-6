package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        isDifferentCarName(cars);
        this.cars = cars;
    }

    private void isDifferentCarName(List<Car> cars) {
        List<CarName> carName = cars.stream()
                .map(idx -> idx.getCarName())
                .collect(Collectors.toList());

        HashSet<CarName> carNameDuplicateSet = new HashSet<>(carName);

        if (carNameDuplicateSet.size() != carName.size()){
            throw new IllegalArgumentException("자동차 이름은 중복으로 사용될 수 없습니다.");
        }
    }

