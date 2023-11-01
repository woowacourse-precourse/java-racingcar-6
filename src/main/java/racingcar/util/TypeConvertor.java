package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class TypeConvertor {
    private static final String SPLIT_UNIT = ",";
    public List<Car> converStringToCarList(String input) {
        List<Car> cars = new ArrayList<>();
        String[] split = input.split(SPLIT_UNIT);
        validateSize(split.length);
        for (String s : split) {
            validateDuplicate(s, cars);
            cars.add(toCar(s));
        }
        return cars;
    }

    public Long convertStringToLong(String input) {
        input = input.trim();
        try {
            long n = Long.parseLong(input);
            if(n < 1) {
                throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR);
            }
            return n;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR);
        }
    }


    private Car toCar(String s) {
        if(s.isEmpty() || s.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR);
        }
        if(s.trim().isEmpty())  {
            throw new IllegalArgumentException(ErrorMessage.WHITE_SPACE_ERROR);
        }
        return new Car(s);
    }

    private void validateSize(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LIST_SIZE_ERROR);
        }
    }
    private void validateDuplicate(String s, List<Car> cars) {
        for (Car car : cars) {
            if(car.isDuplicate(s)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME_ERROR);
            }
        }
    }
}
