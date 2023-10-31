package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.io.InputReader;
import racingcar.io.OutputPrinter;

public class GameController {
    private final InputReader inputReader;
    private final OutputPrinter outputPrinter;

    public GameController(InputReader inputReader, OutputPrinter outputPrinter) {
        this.inputReader = inputReader;
        this.outputPrinter = outputPrinter;
    }

    public void run() {
        outputPrinter.printCarNamePrompt();
        inputReader.readCarNames();
        List<String> carNames = inputReader.getCarNames();

        outputPrinter.printTriesPrompt();
        inputReader.readUserInputCount();
        int tries = inputReader.getUserInputCount();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        Race race = new Race(cars, tries);
        outputPrinter.printExecutionResult();

        for (int i = 0; i < tries; i++) {
            race.startOneRound();
            outputPrinter.printCarsPosition(cars);
            System.out.println();
        }

        List<String> winners = race.getWinners();
        OutputPrinter.printWinners(winners);
    }
}
