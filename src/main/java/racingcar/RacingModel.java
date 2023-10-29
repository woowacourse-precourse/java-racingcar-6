package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingModel {
    private final Cars cars;
    private int attempt;

    public RacingModel(List<String> names, int attempt) {
        this.cars = new Cars(createCarsFromNames(names));
        this.attempt = attempt;
    }

    public void race() {
        attempt--;
        cars.moveRandomEachCars();
    }

    public List<String> findWinners() {
        return cars.findMaxPositionCarNames();
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
