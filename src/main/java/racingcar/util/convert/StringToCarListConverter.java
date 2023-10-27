package racingcar.util.convert;

import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class StringToCarListConverter implements Converter<String, List<Car>>{

    private static final String SPLIT_UNIT = ",";

    @Override
    public boolean supports(Object from, Class<?> to) {
        return from.getClass() == String.class && to == List.class;
    }

    @Override
    public List<Car> convert(String target) {
        List<Name> nameList = convertToNameList(target);
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
