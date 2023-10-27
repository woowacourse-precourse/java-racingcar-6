package racingcar.util;

import racingcar.domain.Car;
import racingcar.domain.Name;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.util.ErrorMessage.DUPLICATE_NAME_ERROR;
import static racingcar.util.ErrorMessage.SPLIT_REGEX_ERROR;

public class TypeConverter {

    private static final String SPLIT_UNIT = ",";
    private static final String SPECIAL_REGEX = "^[!|~₩@#$%^&*().<>/?{}/-_=+]*$";

    public List<Car> convertToCarList(String input) {
        List<Name> nameList = convertToNameList(input);
        return convertToCarList(nameList);
    }

    public List<Name> convertToNameList(String input) {
        String[] split = splitName(input);
        checkDuplicateName(split);
        List<Name> nameList = new ArrayList<>();
        for (String name : split) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

    private String[] splitName(String input) {
        checkSplitUnit(input);
        return input.split(SPLIT_UNIT);
    }

    private void checkSplitUnit(String input) {
        if (input.matches(SPECIAL_REGEX)) {
            throw new IllegalArgumentException(SPLIT_REGEX_ERROR.getMessage());
        }
    }

    private void checkDuplicateName(String[] split) {
        int inputSize = split.length;
        Set<String> temp = new HashSet<>(List.of(split));
        if (inputSize != temp.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR.getMessage());
        }
    }

    public List<Car> convertToCarList(List<Name> nameList) {
        List<Car> cars = new ArrayList<>();
        for (Name name : nameList) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
