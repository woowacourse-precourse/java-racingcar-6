package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.view.Printer;

public class CarController {

    public List<Car> createCars(List<String> names) {
        return names.stream().map(Car::of).collect(Collectors.toList());
    }

    public void race(List<Car> cars, int count) {
        System.out.println("실행 결과");
        IntStream.range(0, count).forEach(i -> {
            cars.forEach(car -> {
                car.drive();
                System.out.println(car);
            });
            System.out.println();
        });
    }

    public List<String> checkWinner(ArrayList<Car> cars) {
        int max = cars.stream().mapToInt(Car::getDistance).max().getAsInt();
        return cars.stream().filter(car -> car.getDistance() == max).map(Car::getName).toList();
    }
}
