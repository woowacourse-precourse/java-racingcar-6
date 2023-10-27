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
        List<String> winners = findWinners();
        view.printWinners(winners);
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

    private List<String> findWinners() {
        List<String> names = new ArrayList<>();
        Car currentWinner = cars.get(0);
        for (Car car : cars) {
            if (currentWinner.compareTo(car) > 0) continue;
            if (currentWinner.compareTo(car) < 0) {
                names.clear();
                currentWinner = car;
            }
            names.add(car.getName());
        }
        return names;
    }
}
