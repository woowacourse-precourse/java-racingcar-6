package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    InputView inputView;
    OutputView outputView;
    List<Car> cars;
    List<String> results;

    RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
        cars = new ArrayList<>();
        results = new ArrayList<>();
    }

    public void play() {
        String[] carNames = inputView.inputCarNames();
        int tryCount = inputView.inputTryCount();
        setupCars(carNames);
        race(tryCount);
        outputView.printCurrentResult(results);
        List<String> winners = findWinners();
        outputView.printWinners(winners);
    }

    private void race(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
            collectResults();
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

    private void collectResults() {
        for (Car car : cars) {
            results.add(car.getCurrentResult());
        }
        results.add("");
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
