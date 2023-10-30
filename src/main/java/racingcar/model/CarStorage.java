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
    public static Integer getMaxSteps() {
        Integer maxSteps = 0;
        for (Integer steps : getStepsList()) {
            if (steps > maxSteps) {
                maxSteps = steps;
            }
        }
        return maxSteps;
    }
    private static List<Integer> getStepsList() {
        for (Car car : cars) {
            stepsList.add(car.steps());
        }
        return stepsList;
    }
}
