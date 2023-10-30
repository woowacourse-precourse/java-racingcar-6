package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public List<Car> findCarsWithMaxMovingCount() {
        cars.sort(Car::compareTo);
        List<Car> maxMovingCounts = new ArrayList<>();

        Car currentCar = cars.get(0);
        maxMovingCounts.add(currentCar);

        for (int i = 1; i < cars.size(); i++) {
            Car nextCar = cars.get(i);
            if (!currentCar.isSameMovingCount(nextCar)) {
                break;
            }
            maxMovingCounts.add(nextCar);
        }

        return maxMovingCounts;
    }

    public void updateMovingCount(int minimumNumber) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
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
