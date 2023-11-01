package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void race() {
        cars.forEach(car -> {
            car.move();
            car.printPosition();
        });
        System.out.println();
    }

    public List<Car> getWinners() {
        List<Car> winners = cars.stream()
                .collect(Collectors.groupingBy(Car::getPosition, Collectors.toList()))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(entry -> entry.getKey()))
                .map(entry -> entry.getValue())
                .orElseThrow();
        return winners;
    }

    public void printWinners() {
        List<Car> winners = getWinners();
        String collect = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + collect);
    }
}
