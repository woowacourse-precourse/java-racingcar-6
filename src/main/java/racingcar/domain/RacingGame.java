package racingcar.domain;

import racingcar.utils.Util;

import java.util.ArrayList;

public class RacingGame {

    private final ArrayList<Car> cars = new ArrayList<>();

    public RacingGame(ArrayList<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public ArrayList<Car> getResultPerAttempt() {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

    public ArrayList<Integer> getCarPosition() {
        ArrayList<Integer> carPosition = new ArrayList<>();
        for (Car car : cars) {
            carPosition.add(car.getPosition());
        }
        return carPosition;
    }

    public String[] getWinner() {
        int winnerPosition = Util.getMaxValue(getCarPosition());
        return cars.stream()
                .filter(car -> car.winOrFail(winnerPosition))
                .map(Car::getName)
                .toArray(String[]::new);
    }

}
