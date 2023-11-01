package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Round;
import racingcar.service.CarsGenerator;
import racingcar.service.Judge;
import racingcar.service.Racing;
import racingcar.view.Printer;
import racingcar.view.Scanner;

public class RacingCarPlayer implements GamePlayer {
    Judge judge;
    CarsGenerator carsGenerator;
    Racing racing;
    Scanner scanner;
    Printer printer;

    public RacingCarPlayer() {
        scanner = Scanner.getInstance();
        printer = Printer.getInstance();
        judge = Judge.getInstance();
        carsGenerator = CarsGenerator.getInstance();
        racing = Racing.getInstance();
    }

    @Override
    public void run() {
        List<Car> carList = generateCars(inputCarNames());
        Round round = inputNumberOfRounds();
        List<Car> winningCars = race(carList, round);
        printResult(winningCars);
    }

    private List<Car> generateCars(List<String> carNames) {
        List<Car> carList;
        carList = carsGenerator.generateCars(carNames);
        return carList;
    }

    private Round inputNumberOfRounds() {
        printer.printInputNumberOfRoundsMessage();
        Integer numberOfRound = scanner.inputNumberOfRounds();
        return new Round(numberOfRound);
    }

    public List<Car> race(List<Car> carList, Round round) {
        printer.printRoundStateMessage();
        while (round.IsNotEnd()) {
            racing.playARound(carList);
            printer.printRoundState(carList);
            round.finishARound();
        }
        return judge.getWinningCars(carList);
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
