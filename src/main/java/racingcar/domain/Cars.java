package racingcar.domain;

import java.util.List;

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
}
