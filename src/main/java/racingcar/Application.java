package racingcar;

import model.Car;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        SetRace set = new SetRace();
        List<Car> cars = set.createCar();
        for (Car car : cars) {
            System.out.println(car.getName());
        }
    }
}
