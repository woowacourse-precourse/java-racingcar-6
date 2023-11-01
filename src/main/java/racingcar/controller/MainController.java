package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.ConsoleWrapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainController {
    public void run() {
        String carNames = ConsoleWrapper.promptCarNames();
        List<Car> cars = Arrays.stream(carNames.split(",")).map(Car::new).collect(Collectors.toList());

        int numOfMoves = ConsoleWrapper.promptNumOfMoves();

        RaceController raceController = new RaceController(cars);
        raceController.run(numOfMoves);

        List<Car> winners = raceController.getWinners();
        ConsoleWrapper.printWinners(winners);
    }
}
