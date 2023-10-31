package Model;

import java.util.*;

public class GameData {

    private Map<String, Integer> cars = new LinkedHashMap<>();

    public void addData(String name) {
        cars.put(name, 0);
    }

    public List<String> getCarList() {
        return new ArrayList<>(cars.keySet());
    }

    public List<Map.Entry<String, Integer>> getResult() {
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(cars.entrySet());
        entryList.sort(((o1, o2) -> cars.get(o2.getKey()).compareTo(cars.get(o1.getKey()))));
        return entryList;
    }

    public int moveForward(String name, int move) {
        cars.put(name, cars.get(name)+move);
        return cars.get(name);
    }

    public boolean ContainsData(String name) {
        return cars.containsKey(name);
    }
}
