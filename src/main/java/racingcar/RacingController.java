package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    View view;
    List<Car> cars;

    RacingController() {
        view = new View();
        cars = new ArrayList<>();
    }

    public void play() {
        String[] carNames = view.inputCarNames();
        int tryCount = view.inputTryCount();
        setupCars(carNames);
        race(tryCount);
    }

    private void race(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
            view.printCurrentResult(collectResults());
        }
    }

    private void setupCars(String[] carNames) {
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<String> collectResults() {
        List<String> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(car.getCurrentResult());
        }
        return results;
    }
}
