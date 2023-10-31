package racingcar.model;

import java.util.HashMap;

public class Result {
    private HashMap<String, Integer> cars;
    private int count;

    public Result() {
        cars = new HashMap<>();
    }

    public HashMap<String, Integer> getCars() {
        return cars;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void putName(String name) {
        cars.put(name, 0);
    }

    public void putScore(String name, int i) {
        cars.put(name, cars.get(name) + i);
    }

    public Integer getScore(String name) {
        return cars.get(name);
    }
}
