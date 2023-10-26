package racingcar.util;

import racingcar.entity.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constants.ErrorConstants.DUPLICATE_NAME_ERROR_MESSAGE;

public class CarListConverter {

    public static List<Car> convertStringArrayToCarList(String[] names){
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
