package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final String DELIMITER = ",";
    private static Cars singletonInstance;
    private List<Car> cars;

    private Cars() {
        cars = new ArrayList<>();
    }

    public static Cars getInstance() {
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

    public String runSingleRace() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            car.randomMoveForward();
            String moveResult = car.getMoveResult();
            stringBuilder.append(moveResult);
        }
        return stringBuilder.toString();
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

    private void validatePlayerNumber() {
        if (cars.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.PLAYER_NUMBER.toString());
        }
    }

    private WinnerData createWinnerData() {
        Car winner = cars.get(0);
        return winner.createWinnerData();
    }
}
