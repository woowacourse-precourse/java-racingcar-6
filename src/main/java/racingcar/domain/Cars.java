package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        initCar(carNames);
    }

    private void initCar(List<String> carNames) throws IllegalArgumentException {
        checkDuplication(carNames);

        cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private void checkDuplication(List<String> carNames) {
        HashSet<String> hashSet = new HashSet<>(carNames);

        if (hashSet.size() < carNames.size()) {
            throw new IllegalArgumentException("err: 자동차 이름이 중복되면 안됩니다.");
        }
    }
}
