package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.IoManager;

public class CarFactory {

    public List<Car> createCars() {
        IoManager.printEnterCarName();
        String nameString = IoManager.readLine();
        List<String> nameList = stringToListByComma(nameString);
        checkDuplicatedName(nameList);
        return createCarList(nameList);
    }

    private List<Car> createCarList(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<String> stringToListByComma(String name) {
        return Arrays.stream(name.split(","))
                .collect(Collectors.toList());
    }

    private void checkDuplicatedName(List<String> names) {
        if (countDistinctListSize(names) != names.size()) {
            throw new IllegalArgumentException("중복된 이름");
        }
    }

    private Long countDistinctListSize(List<String> list) {
        return list.stream().distinct().count();
    }
}
