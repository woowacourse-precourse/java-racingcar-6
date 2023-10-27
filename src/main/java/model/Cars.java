package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private static final int MIN_RANGE_NUMBER = 1;
    private static final int MAX_RANGE_NUMBER = 9;
    private static final int MINIMUM_NUMBER = 4;

    public Cars(String[] names) {
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name));
        }

        this.cars = carList;
    }

    public Car indexAt(int index) {
        return cars.get(index);
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        cars.sort(Car::compareTo);

        Car currentCar = cars.get(0);
        winners.add(currentCar.toString());

        for (int i = 1; i < cars.size(); i++) {
            Car nextCar = cars.get(i);
            if (!currentCar.isSameMovingCount(nextCar)) {
                break;
            }
            winners.add(nextCar.toString());
        }

        return winners;
    }

    public void applyRandomMovingCountIncrease() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
            car.increaseMovingCountIfGreater(MINIMUM_NUMBER, randomNumber);
        }
    }

    public static String getRacingStatusOfAllCars(Cars racingCars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : racingCars.cars) {
            stringBuilder.append(car.currentRacingStatus());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}
