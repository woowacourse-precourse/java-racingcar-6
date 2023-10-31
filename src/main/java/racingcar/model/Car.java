package racingcar.model;

import racingcar.util.CarUtil;

import java.util.*;

public class Car {

    private static final int CAR_MOVE_STEP = 1;

    private Map<String, Integer> carData = new LinkedHashMap<>();

    public Map<String, Integer> getCarData() {
        return this.carData;
    }

    public void initCar(List<String> carlist) {
        for (String element : carlist) {
            this.carData.put(element, 0);
        }
    }

    public void move() {
        carData.forEach((key, value) -> {
            if (CarUtil.isCanMove()) {
                carData.replace(key, value + CAR_MOVE_STEP);
            }
        });
    }

    private int findMaxPosition() {
        return carData.values()
                .stream().mapToInt(v -> v).max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<String> findWinner() {
        List<String> result = new ArrayList<>();

        carData.entrySet().stream()
                .filter(car -> car.getValue() == findMaxPosition())
                .forEach(car -> result.add(car.getKey()));
        return result;
    }
}
