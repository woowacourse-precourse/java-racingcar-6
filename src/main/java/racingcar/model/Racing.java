package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Racing {
    private final Cars cars;
    private int attempt;

    public Racing(List<String> names, int attempt) {
        this.cars = new Cars(createCarsFromNames(names));
        this.attempt = attempt;
    }

    public void race() {
        attempt--;
        cars.moveRandomEachCars();
    }

    public List<String> findWinners() {
        int max = cars.findMaxPosition();
        return cars.findCarNamesAt(max);
    }

    public Map<String, Integer> getStatus() {
        return cars.getCarsStatus();
    }

    public boolean isEnd() {
        return attempt == 0;
    }

    private List<Car> createCarsFromNames(List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
