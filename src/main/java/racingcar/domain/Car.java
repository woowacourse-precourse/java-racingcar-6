package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private Map<String, Integer> cars;

    public Car() {
    }

    public Car(String inputName) {
        cars = initToMap(validateNameLength(splitNames(inputName)));
    }

    private Map<String, Integer> initToMap(String[] names) {
        Map<String, Integer> cars = new HashMap<>();
        for (String name : names) {
            cars.put(name, 0);
        }
        return cars;
    }

    private String[] splitNames(String inputName) {
        return inputName.split(",");
    }

    private String[] validateNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 가능합니다.");
            }
        }
        return names;
    }

    public void forward(Map.Entry<String, Integer> entry) {
        int step = entry.getValue() + 1;
        this.cars.put(entry.getKey(), step);
    }

    private boolean isForward() {
        return NumberGenerator.generateRandomNumber() >= 4;
    }

    public Map<String, Integer> getCars() {
        return cars;
    }
}
