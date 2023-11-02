package model;

import static utils.Generator.generateRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findCarsWithMaxMovingCount() {
        cars.sort(Car::compareTo);
        List<Car> maxMovingCounts = new ArrayList<>();

        Car winnerCar = cars.get(0);
        for (Car car : cars) {
            if (!winnerCar.isSameMovingCount(car)) {
                break;
            }
            maxMovingCounts.add(car);
        }

        return maxMovingCounts;
    }

    public void updateMovingCount(int minimumNumber) {
        for (Car car : cars) {
            if (generateRandomNumber() >= minimumNumber) {
                car.move();
            }
        }
    }

    public String getAllCarsStatus() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            stringBuilder.append(car.currentRacingStatus());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
