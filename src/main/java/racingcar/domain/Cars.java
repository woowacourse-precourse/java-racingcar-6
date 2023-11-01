package racingcar.domain;

import java.util.List;

import static racingcar.view.ExceptionMessage.ExceprionMessage.IS_INVALID_DUPLICATE_CAR_NAME;


public class Cars {
    public static List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    public void validateDuplicate(List<Car> cars) {
        int hasDuplicate = (int)cars.stream().
                map(car -> car.carName).
                distinct()
                .count();

        if (hasDuplicate < cars.size()) {
            throw new IllegalArgumentException(IS_INVALID_DUPLICATE_CAR_NAME);
        }
    }
}
