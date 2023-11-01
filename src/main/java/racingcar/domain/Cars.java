package racingcar.domain;

import java.util.ArrayList;

public class Cars {
    private final ArrayList<Car> cars;

    public Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(ArrayList<Car> cars) {
        return new Cars(cars);
    }

    public int determineMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public Cars determineWinner(int maxDistance) {
        ArrayList<Car> bestCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                bestCars.add(car);
            }
        }
        return Cars.of(bestCars);
    }
}
