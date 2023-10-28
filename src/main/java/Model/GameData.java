package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameData {

    private Map<String, Integer> cars = new HashMap<>();

    public void addData(String name) {
        cars.put(name, 0);
    }

    public List<String> getCarList() {
        return new ArrayList<>(cars.keySet());
    }

    public Map<String, Integer> getResult() {
        List<String> keyset = new ArrayList<>(cars.keySet());
        keyset.sort(((o1, o2) -> cars.get(o2).compareTo(cars.get(o1))));
        return cars;
    }

    public int moveForward(String name, int move) {
        cars.put(name, cars.get(name)+move);
        return cars.get(name);
    }

    public boolean ContainsData(String name) {
        return cars.containsKey(name);
    }
}
