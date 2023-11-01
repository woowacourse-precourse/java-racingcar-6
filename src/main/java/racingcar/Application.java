package racingcar;

import racingcar.controller.Race;
import racingcar.controller.SetRace;
import racingcar.model.Car;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        SetRace set = new SetRace();
        List<Car> cars = set.createCar();
        int number = set.inputMovement();

        Race race = new Race();
        race.raceCar(cars,number);
    }
}
