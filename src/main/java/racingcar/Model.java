package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static final List<Car> cars = new ArrayList<>();
    private static int tries = 0;

    public static void setCar(String name) {
        Car car = new Car(name);
        cars.add(car);
    }

    public static void setNumberOfTries(int num) {
        tries = num;
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static int getNumberOfTries() {
        return tries;
    }

    public static List<String> getWinnersName() {
        return getWinnersCar().stream().map(Car::getName).collect(Collectors.toList());
    }

    private static List<Car> getWinnersCar() {
        return cars.stream().filter(Car::isWinner).collect(Collectors.toList());
    }
}
