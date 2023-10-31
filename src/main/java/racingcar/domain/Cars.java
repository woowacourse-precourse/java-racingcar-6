package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(String input) {
        this.cars = parseInput(input);
    }

    private List<Car> parseInput(String input) {
        String[] names = input.split(",");
        List<Car> carList = new ArrayList<>();
        Set<String> nameSet = new HashSet<>();

        for (String name : names) {
            name = name.trim();
            if (nameSet.contains(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없음.");
            }
            carList.add(new Car(name));
            nameSet.add(name);
        }

        return carList;
    }

    public List<Car> getCars() {
        return cars;
    }
}
