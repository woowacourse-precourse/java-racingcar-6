package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private final List<String> carNames;
    private Map<String, Car> cars = new HashMap<>();

    public Race(List<String> carNames) {
        this.carNames = carNames;
        for (String name : carNames) {
            cars.put(name, new Car(name));
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    private Car getCar(String carName) {
        return cars.get(carName);
    }

    public int getDistance(String carName) {
        return getCar(carName).getDistance();
    }

    public void doAttempt() {
        // TODO: implement Random advance logic
        for (Car car : cars.values()) {
            car.advance();
        }
    }
}
