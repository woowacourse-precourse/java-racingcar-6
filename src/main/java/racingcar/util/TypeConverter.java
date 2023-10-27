package racingcar.util;

import racingcar.domain.Car;
import racingcar.domain.Name;

import java.util.ArrayList;
import java.util.List;

public class TypeConverter {

    private static final String SPLIT_UNIT = ",";

    public List<Car> convertToCarList(String input) {
        List<Name> nameList = convertToNameList(input);
        return convertToCarList(nameList);
    }

    public List<Name> convertToNameList(String input) {
        String[] split = splitName(input);
        Validator.checkDuplicateName(split);
        List<Name> nameList = new ArrayList<>();
        for (String name : split) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

    private String[] splitName(String input) {
        Validator.checkSplitUnit(input);
        return input.split(SPLIT_UNIT);
    }

    public List<Car> convertToCarList(List<Name> nameList) {
        List<Car> cars = new ArrayList<>();
        for (Name name : nameList) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
