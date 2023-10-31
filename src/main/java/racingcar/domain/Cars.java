package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    static private List<Car> cars;

    private Cars() {
    }

    static public void initializeByInput(String input) {
        cars = new ArrayList<>();
        String[] names = input.split(",");
        for (String name : names) {
            Car car = new Car(name.trim());
            cars.add(car);
        }
    }

    static public RaceResult runSingleRace() {
        RaceResult raceResult = new RaceResult();
        for (Car car : cars) {
            car.moveForward();
            car.saveResult(raceResult);
        }
        return raceResult;
    }

    static public WinnerData pickWinners() {
        Collections.sort(cars);
        WinnerData winnerData = createWinnerData();

        int index = 0;
        Car car = cars.get(index);
        while (car.isWinner(winnerData)) {
            car.addWinner(winnerData);
            car = cars.get(++index);
        }
        return winnerData;
    }

    static private WinnerData createWinnerData() {
        Car winner = cars.get(0);
        return winner.createWinnerData();
    }
}
