package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.RaceResult;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        List<String> carNames = InputHandler.getCarNames();
        int attemptCount = InputHandler.getAttemptCount();
        List<Car> cars = initializeCars(carNames);

        Race race = new Race(cars);
        executeRacing(attemptCount, race, cars);

        List<Car> winners = RaceResult.getWinners(cars);
        OutputHandler.printWinners(winners);
    }

    private List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void executeRacing(int attemptCount, Race race, List<Car> cars) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            race.raceOnce();
            OutputHandler.printRaceState(cars);
        }
    }
}
