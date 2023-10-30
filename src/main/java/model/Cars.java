package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public List<String> findMaxMovingCount() {
        cars.sort(Car::compareTo);
        List<String> maxMovingCounts = new ArrayList<>();

        Car currentCar = cars.get(0);
        maxMovingCounts.add(currentCar.toString());

        for (int i = 1; i < cars.size(); i++) {
            Car nextCar = cars.get(i);
            if (!currentCar.isSameMovingCount(nextCar)) {
                break;
            }
            maxMovingCounts.add(nextCar.toString());
        }

        return maxMovingCounts;
    }

    public void updateMovingCount(int minimumNumber) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            car.increaseMovingCountIfGreater(minimumNumber, randomNumber);
        }
    }

    public String getAllCarsStatus() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            stringBuilder.append(car.currentRacingStatus());
            stringBuilder.append("\n");
        }
        
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
