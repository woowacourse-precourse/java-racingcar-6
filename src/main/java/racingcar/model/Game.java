package racingcar.model;

import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> cars = new HashMap<>();

    public HashMap<String, Integer> getCars() {
        return cars;
    }

    public void addCar(String name) {
        cars.put(name, 0);
    }

    public void editStatus(String key) {
        Integer originalStatus = cars.get(key);
        cars.replace(key, originalStatus + 1);
    }
}
