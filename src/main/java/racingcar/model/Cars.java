package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final String DUPLICATE_CAR_NAME = "중복된 자동차 이름입니다.";

    private List<Car> cars;

    public Cars(String inputCarNames) {
        List<Car> createdCars = createCars(inputCarNames);
        validateCarDuplicated(createdCars);
        this.cars = createdCars;
    }


    public int carsSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


    private void validateCarDuplicated(List<Car> cars) {
        int originSize = cars.size();
        Set<Car> set = new HashSet<>(cars);
        
        if (isSameSize(originSize, set.size())) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }

    private boolean isSameSize(int originSize, int setSize) {
        return originSize != setSize;
    }

    private List<Car> createCars(String inputCarNames) {
        return Arrays.stream(inputCarNames.split(SpecialSign.SEPARATOR.getSign()))
                .map(Car::new)
                .toList();
    }
}
