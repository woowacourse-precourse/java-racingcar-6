package racingcar.util;

import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constants.ErrorConstants.DUPLICATE_NAME_ERROR_MESSAGE;

public class CarListConverter {
    private CarListConverter() {
    }

    public static List<Car> convertCarNamesToCarList(String[] names){
        List<Car> cars = Arrays.stream(names)
                .distinct()
                .map(Car::new)
                .collect(Collectors.toList());

        validateDuplicate(names.length, cars.size());

        return cars;
    }

    private static void validateDuplicate(int oldNameSize, int carSize){
        if (oldNameSize != carSize){
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

}
