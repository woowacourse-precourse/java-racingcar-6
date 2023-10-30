package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = InputManager.getCars();
        int trials = InputManager.getTrials();
        Race race = new Race(cars, trials);

        race.executeRace();

        OutputManager.displayWinners(race.getWinners());
    }
}
