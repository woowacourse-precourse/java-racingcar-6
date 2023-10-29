package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void saveCars(String input) {
        if (!validateInput(input)) {
            throw new IllegalArgumentException();
        }
        String[] parts = input.split(",");
        for (int i = 0; i < parts.length; i++) {
            cars.add(new Car(parts[i]));
        }
    }

    private boolean validateInput(String input) {
        String[] parts = input.split(",");
        for (String part : parts) {
            if (part.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return this.cars.size();
    }

    public void moveCar(int index) {
        this.cars.get(index).increaseLocation();
    }

    public Map<String, Integer> getCarsInfo() {
        Map<String, Integer> result = new HashMap<>();
        cars.forEach(car -> result.put(car.getName(), car.getLocation()));
        return result;
    }

}
