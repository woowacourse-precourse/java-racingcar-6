package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private static final int CAR_INIT_COUNT = 0;
    private static final int CAR_MOVE_DISTANCE = 1;
    private final LinkedHashMap<String, Integer> cars = new LinkedHashMap<>();

    public void addCars(List<String> carNameList) {
        initializeCars(carNameList);
    }

    private void initializeCars(List<String> carNameList) {
        for (String name : carNameList) {
            cars.put(name, CAR_INIT_COUNT);
        }
    }

    public HashMap<String, Integer> getCars() {
        return this.cars;
    }

    public void moveCar(String carName) {
        Integer position = cars.get(carName);
        if (position != null) {
            cars.put(carName, position + CAR_MOVE_DISTANCE);
        }
    }

    public ArrayList<String> determineFinalWinner() {
        int highestPosition = getHighestPosition();
        return getWinners(highestPosition);
    }

    private int getHighestPosition() {
        return this.cars.values().stream()
                .max(Integer::compareTo)
                .orElse(-1);
    }

    private ArrayList<String> getWinners(int highestPosition) {
        return this.cars.entrySet().stream()
                .filter(entry -> entry.getValue() == highestPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

