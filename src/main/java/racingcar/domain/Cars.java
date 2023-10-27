package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(String[] cars) {
        validateCars(cars);
        carList = generateCarList(cars);
    }

    private List<Car> generateCarList(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            this.carList.add(new Car(car));
        }
        return carList;
    }

    private void validateCars(String[] cars) {
        if (hasDuplicatedCarName(cars)) {
            throw new IllegalArgumentException("중복된 자동차 이름을 입력하였습니다.");
        }
    }
    private boolean hasDuplicatedCarName(String[] cars) {
        HashSet<String> carSet = new HashSet<String>();
        Collections.addAll(carSet, cars);
        return cars.length > carSet.size();
    }
}
