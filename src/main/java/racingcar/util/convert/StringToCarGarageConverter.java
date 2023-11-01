package racingcar.util.convert;

import racingcar.domain.CarGarage;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class StringToCarGarageConverter implements Converter<String, CarGarage>{

    private static final String SPLIT_UNIT = ",";

    @Override
    public boolean supports(Object from, Class<?> to) {
        return from.getClass() == String.class && to == CarGarage.class;
    }

    @Override
    public CarGarage convert(String target) {
        List<Name> nameList = convertToNameList(target);
        List<Car> cars = convertToCarList(nameList);
        return new CarGarage(cars);
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
        Validator.checkBlank(input);
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
