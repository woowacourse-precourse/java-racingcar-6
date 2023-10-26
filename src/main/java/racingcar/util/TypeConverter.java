package racingcar.util;

import racingcar.domain.Car;
import racingcar.domain.Name;

import java.util.ArrayList;
import java.util.List;

public class TypeConverter {

    public List<String> convertToNameList(String input) {
        checkSplitUnit(input);
        String[] split = input.split(",");
        return List.of(split);
    }

    private void checkSplitUnit(String input) {
        if (input.matches("")) {
            throw new IllegalArgumentException("쉼표(,)로만 구분 가능합니다.");
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
