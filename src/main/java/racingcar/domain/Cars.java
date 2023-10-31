package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    static private Cars singletonInstance;
    static private final String DELIMITER = ",";
    private List<Car> cars;

    private Cars() {
        cars = new ArrayList<>();
    }

    static public Cars getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Cars();
        }
        return singletonInstance;
    }

    public void addCarsFromInput(String input) {
        String[] names = input.split(DELIMITER);
        for (String name : names) {
            Car car = new Car(name.trim());
            cars.add(car);
        }
        validatePlayerNumber();
    }

    private void validatePlayerNumber() {
        if (cars.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.PLAYER_NUMBER.toString());
        }
    }

    public RaceResult runSingleRace() {
        RaceResult raceResult = new RaceResult();
        for (Car car : cars) {
            car.randomMoveForward();
            car.saveResult(raceResult);
        }
        return raceResult;
    }

    public WinnerData pickWinners() {
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

    private WinnerData createWinnerData() {
        Car winner = cars.get(0);
        return winner.createWinnerData();
    }
}
