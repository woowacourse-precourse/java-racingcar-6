package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.service.CarsGenerator;
import racingcar.service.JudgeMachine;
import racingcar.service.Racing;
import racingcar.view.Printer;
import racingcar.view.Scanner;

public class RacingCarPlayer implements GamePlayer {
    JudgeMachine judgeMachine;
    CarsGenerator carsGenerator;
    Racing racing;
    Scanner scanner;
    Printer printer;

    public RacingCarPlayer() {
        scanner = new Scanner();
        printer = new Printer();
        judgeMachine = new JudgeMachine();
        carsGenerator = new CarsGenerator();
        racing = new Racing();
    }

    @Override
    public void run() {
        List<Car> carList = generateCars(inputCarNames());
        Integer numberOfRounds = inputNumberOfRounds();
        List<Car> winningCars = race(carList, numberOfRounds);
        printResult(winningCars);
    }

    private List<Car> generateCars(List<String> carNames) {
        List<Car> carList;
        carList = carsGenerator.generateCars(carNames);
        return carList;
    }

    private Integer inputNumberOfRounds() {
        printer.printInputNumberOfRoundsMessage();
        return scanner.inputNumberOfRound();
    }

    public List<Car> race(List<Car> carList, Integer numberOfRounds) {
        printer.printRoundStateMessage();
        for (int round = 1; round <= numberOfRounds; round++) {
            racing.playARound(carList);
            printer.printRoundState(carList);
        }
        return judgeMachine.getWinningCars(carList);
    }
    private List<String> inputCarNames() {
        printer.printInputCarNamesMessage();
        List<String> carNames = scanner.inputCarNames();
        return carNames;
    }
    private void printResult(List<Car> winningCars) {
        printer.printResult(winningCars);
    }
}
