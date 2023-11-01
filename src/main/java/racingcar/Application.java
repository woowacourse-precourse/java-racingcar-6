package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();

        List<String> carNames = inputManager.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        int rounds = inputManager.getTryCount();

        RaceManager raceManager = new RaceManager(cars, rounds);
        raceManager.race();

        outputManager.printWinners(raceManager.getWinners());
    }
}
