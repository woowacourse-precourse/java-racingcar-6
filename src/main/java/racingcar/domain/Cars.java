package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int CAR_COUNT_MINIMUM = 2;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        isDifferentCarName(cars);
        minimumCountOfCars(cars.size());
        this.cars = cars;
    }

    private void isDifferentCarName(List<Car> cars) {
        List<String> carName = cars.stream()
                .map(idx -> idx.getCarName())
                .collect(Collectors.toList());

        HashSet<String> carNameDuplicateSet = new HashSet<>(carName);

        if (carNameDuplicateSet.size() != carName.size()){
            throw new IllegalArgumentException("자동차 이름은 중복으로 사용될 수 없습니다.");
        }
    }

    private void minimumCountOfCars(int size) {
        if (size < CAR_COUNT_MINIMUM){
            throw new IllegalArgumentException("자동차는 최소 2대 이상 생성해야 합니다.");
        }
    }
}
