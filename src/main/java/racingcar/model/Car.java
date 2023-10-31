package racingcar.model;

import racingcar.util.CarUtil;

import java.util.*;

public class Car {

    private static final int MORE_THAN_NUMBER = 4;
    private static final int CAR_MOVE_STEP = 1;
    private static final int CAR_INIT_POSITION = 0;

    private Map<String, Integer> carData = new LinkedHashMap<>();

    public Map<String, Integer> getCarData() {
        return this.carData;
    }

    public void initCar(List<String> carlist) {
        for (String element : carlist) {
            this.carData.put(element, CAR_INIT_POSITION);
        }
    }

    public void move() {
        carData.forEach((key, value) -> {
            if (isCanMove()) {
                carData.replace(key, value + CAR_MOVE_STEP);
            }
        });
    }

    private int findMaxPosition() {
        return carData.values()
                .stream().mapToInt(v -> v).max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<String> findWinners() {
        List<String> result = new ArrayList<>();

        carData.entrySet().stream()
                .filter(car -> car.getValue() == findMaxPosition())
                .forEach(car -> result.add(car.getKey()));
        return result;
    }

    private boolean isCanMove() {
        return CarUtil.getRandomValue() >= MORE_THAN_NUMBER;
    }
}
