package racingcar.util;

import racingcar.domain.Car;
import racingcar.domain.Name;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.ErrorMessage.SPLIT_REGEX_ERROR;

public class TypeConverter {

    private static final String SPLIT_UNIT = ",";
    private static final String SPECIAL_REGEX = "^[!|~₩@#$%^&*().<>/?{}/-_=+]*$";

    public List<String> convertToNameList(String input) {
        checkSplitUnit(input);
        String[] split = input.split(SPLIT_UNIT);
        return List.of(split);
    }

    private void checkSplitUnit(String input) {
        if (input.matches(SPECIAL_REGEX)) {
            throw new IllegalArgumentException(SPLIT_REGEX_ERROR.getMessage());
        }
    }

    public List<Car> convertToCarList(List<String> nameList) {
        List<Car> cars = new ArrayList<>();
        for (String name : nameList) {
            Name carName = new Name(name);
            cars.add(new Car(carName));
        }
        return cars;
    }
}
