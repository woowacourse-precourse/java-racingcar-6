package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void insertCarsNames(List<String> names) {
        cars.clear();
        cars = namesToCars(names);
    }

    public List<Car> rushCars() {
        cars.forEach(car -> {
            if (car.canRush()) {
                car.rush();
            }
        });
        return cars;
    }

    public List<Car> findWinners() {
        int winnerLocationValue = getCarWithLongestLocation();
        return cars.stream()
                .filter((c)-> c.getLocation() == winnerLocationValue)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getCarWithLongestLocation() {
        return Collections
                .max(cars, Comparator.comparingInt(Car::getLocation))
                .getLocation();
    }

    private List<Car> namesToCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }
}