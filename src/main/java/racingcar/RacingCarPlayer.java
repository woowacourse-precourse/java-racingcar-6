package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarPlayer implements GamePlayer {
    List<Car> carList;
    Integer numberOfCars;
    Integer numberOfRounds;
    Configurations configurations;
    AdvancingMachine advancingMachine;
    JudgeMachine judgeMachine;
    Scanner scanner;
    Printer printer;
    RandomNumbersGenerator randomNumbersGenerator;
    @Override
    public void run() {
        initialization();
        printer.printRoundStateMessage();
        for (int round = 1; round <= numberOfRounds; round++) {
            playARound();
            printer.printCurrent(carList);
        }
        List<Car> winningCars = judgeMachine.getWinningCars(carList);
        printer.printResult(winningCars);
    }

    RacingCarPlayer() {
        configurations = new Configurations();
        advancingMachine = new AdvancingMachine(configurations.getControlValue(), configurations.getMovingDistance());
        scanner = new Scanner(configurations);
        printer = new Printer();
        judgeMachine = new JudgeMachine();
        carList = new ArrayList<>();
    }

    private void generateCars(List<String> carNames) {
        for (String name : carNames) {
            Car car = new Car(name);
            carList.add(car);
        }
    }

    private void playARound() {
        List<Integer> randomNumberList = randomNumbersGenerator.generate();
        for (int i = 0; i < numberOfCars; i++) {
            Integer currentValue = randomNumberList.get(i);
            Car car = carList.get(i);
            car.setCurrentValue(currentValue);
            advancingMachine.Advance(car);
        }
    }

    private void initialization(){
        printer.printInputCarNamesMessage();
        List<String> carNames = scanner.inputCarNames();
        generateCars(carNames);
        printer.printInputNumberOfRoundsMessage();
        numberOfRounds = scanner.inputNumberOfRound();
        numberOfCars = carList.size();
        randomNumbersGenerator = new RandomNumbersGenerator(
                configurations.getMinimumOfRange(), configurations.getMaximumOfRange(), numberOfCars);
    }
}
