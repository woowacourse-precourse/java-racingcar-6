package racingcar;

import model.Car;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        SetRace set = new SetRace();
        Race race = new Race();
        List<Car> cars = set.createCar();
        int number = set.inputMovement();
//        for (Car car : cars) {
//            System.out.println(car.getName());
//        }
        System.out.println(race.raceCar(cars,number));
    }
}
