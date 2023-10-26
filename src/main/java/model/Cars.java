package model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

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

    public String[] winner() {
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

        return winners.toArray(new String[winners.size()]);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
