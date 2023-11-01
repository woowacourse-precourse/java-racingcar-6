package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Car {
    private Map<String, Integer> cars;
    private final int NAME_SIZE = 5;
    private final int MOVING_FORWARD = 4;

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
            if (isNameGraterThan(name)) {
                throw new IllegalArgumentException("자동차 이름은 " + NAME_SIZE + "자 이하로만 가능합니다.");
            }
        }
        return names;
    }

    private boolean isNameGraterThan(String name) {
        return name.length() > NAME_SIZE;
    }

    public void forward(Map.Entry<String, Integer> entry, int randomNumber) {
        if (!isForward(randomNumber)) {
            return;
        }
        int step = entry.getValue() + 1;
        cars.put(entry.getKey(), step);
    }

    public boolean isForward(int randomNumber) {
        return randomNumber >= MOVING_FORWARD;
    }

    public Map<String, Integer> getCars() {
        return cars;
    }
}
