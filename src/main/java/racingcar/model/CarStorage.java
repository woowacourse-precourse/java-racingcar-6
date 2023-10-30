package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarStorage {
    private static List<Car> winners;
    private static List<Car> cars;
    private static List<Integer> stepsList;
    public CarStorage() {}
    public static void init() { // GameManager에서 1번만 호출
        cars = new ArrayList<>();
        winners = new ArrayList<>();
        stepsList = new ArrayList<>();
    }
    public static List<Car> cars() {
        return cars;
    }
    public static void addCar(Car car) {
        cars.add(car);
    }
    public static List<Car> winners() {
        return winners;
    }
    public static void addWinner(Car winner) {
        winners.add(winner);
    }
}
