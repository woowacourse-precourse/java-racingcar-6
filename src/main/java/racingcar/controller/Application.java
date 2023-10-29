package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.RaceResult;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputHandler.getCarNames();
        int attemptCount = InputHandler.getAttemptCount();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        Race race = new Race(cars);

        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            race.raceOnce();
            OutputHandler.printRaceState(cars);
        }

        List<Car> winners = RaceResult.getWinners(cars);
        OutputHandler.printWinners(winners);
    }
}
