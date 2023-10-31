package model;

import java.util.ArrayList;
import java.util.List;
import utils.Generator;

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
            int randomNumber = Generator.generateRandomNumber();
            car.increaseMovingCountIfGreater(minimumNumber, randomNumber);
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
