package racingcar.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Car {
    private Map<String, Integer> cars;

    public Car() {
    }

    public Car(String inputName) {
        cars = initToMap(splitNames(inputName));
    }

    private Map<String, Integer> initToMap(String[] names) {
        Map<String, Integer> cars = new HashMap<>();
        for (String name : names) {
            cars.put(name, 0);
        }
        return cars;
    }

    private String[] splitNames(String inputName) {
        String[] names = inputName.split(",");
        for (String name : names) {
            validateNameLength(name);
        }
        return names;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로만 가능합니다.");
        }
    }

    public void forward() {
        Iterator<Map.Entry<String, Integer>> iterator = cars.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            int step = entry.getValue() + 1;
            this.cars.put(entry.getKey(), step);
        }
    }

    public Map<String, Integer> getCars() {
        return cars;
    }
}
