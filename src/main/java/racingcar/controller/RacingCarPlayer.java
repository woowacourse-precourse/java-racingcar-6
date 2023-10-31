package racingcar.controller;

import java.util.List;
import racingcar.configurations.Configurations;
import racingcar.domain.Car;
import racingcar.service.CarsGenerator;
import racingcar.service.JudgeMachine;

public class RacingCarPlayer implements GamePlayer {
    Configurations configurations;
    JudgeMachine judgeMachine;
    Scanner scanner;
    Printer printer;

    @Override
    public void run() {
        List<Car> carList = generateCars(inputCarNames());
        Integer numberOfRounds = inputNumberOfRounds();
        race(numberOfRounds,carList);
        List<Car> winningCars = judgeMachine.getWinningCars(carList);
        printer.printResult(winningCars);
    }

    public RacingCarPlayer() {
        configurations = new Configurations();
        scanner = new Scanner(configurations.getDelimiter(), configurations.getMaximumNameLength());
        printer = new Printer();
        judgeMachine = new JudgeMachine();
    }
    private List<Car> generateCars(List<String> carNames) {
        List<Car> carList;
        CarsGenerator carsGenerator = new CarsGenerator(configurations);
        carList = carsGenerator.generateCars(carNames);
        return carList;
    }
    private Integer inputNumberOfRounds() {
        printer.printInputNumberOfRoundsMessage();
        Integer numberOfRounds = scanner.inputNumberOfRound();
        return numberOfRounds;
    }
    private void race(Integer numberOfRounds, List<Car> carList) {
        printer.printRoundStateMessage();
        for (int round = 1; round <= numberOfRounds; round++) {
            playARound(carList);
            printer.printRoundState(carList);
        }
    }
    private void playARound(List<Car> carList) {
        for (Car car : carList) {
            car.advance();
        }
    }

    private List<String> inputCarNames() {
        printer.printInputCarNamesMessage();
        List<String> carNames = scanner.inputCarNames();
        return carNames;
    }
}
