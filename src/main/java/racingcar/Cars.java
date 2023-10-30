package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        validateCarNames(carNames);
        this.cars = initCars(carNames);
    }

    private void validateCarNames(String[] carNames) {
        long distinctCount = Arrays.stream(carNames)
                .distinct()
                .count();
        if (carNames.length > distinctCount) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름을 가질 수 없습니다.");
        }
    }

    public List<Car> initCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

}
