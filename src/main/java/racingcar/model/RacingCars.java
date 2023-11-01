package racingcar.model;

import racingcar.model.Car;

import java.util.*;

import static java.util.Collections.max;

public class RacingCars {
    public ArrayList<Car> cars = new ArrayList<>();

    public RacingCars(ArrayList<String> cars) {
        for (String car : cars) {
            this.cars.add(new Car(car));
        }
    }

    public ArrayList<Car> getRoundResult() {
        for (Car car : cars) {
            car.go();
        }
        return cars;
    }

    public ArrayList<Integer> getPosition() {
        ArrayList<Integer> position = new ArrayList<>();
        for (Car car : cars) {
            position.add(car.getPosition());
        }
        return position;
    }

    public String[] getWinners() {
        int winnerPosition = maxDistance(getPosition());
        return cars
                .stream().filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public static int maxDistance(ArrayList<Integer> position) {
        return Collections.max(position);
    }
}
