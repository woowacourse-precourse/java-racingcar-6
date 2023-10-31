package racingcar;

import model.Car;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        SetRace set = new SetRace();
        Race race = new Race();
        List<Car> cars = set.createCar();
        int number = set.inputMovement();
        race.raceCar(cars,number);
    }
}
