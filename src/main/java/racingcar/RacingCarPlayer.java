package racingcar;

import java.util.List;

public class RacingCarPlayer implements GamePlayer {
    List<Car> carList;
    Integer numberOfCars;
    Integer numberOfRounds;
    Configurations configurations;
    AdvancingMachine advancingMachine;
    Scanner scanner;
    Printer printer;
    RandomNumbersGenerator randomNumbersGenerator;
    @Override
    public void run() {
        generateCars(scanner.inputCarNames());
        numberOfRounds = scanner.inputNumberOfRound();
        randomNumbersGenerator = new RandomNumbersGenerator(
                configurations.getMinimumOfRange(), configurations.getMaximumOfRange(), carList.size());
        printer.printRoundStateMessage();
        for (int round = 1; round < numberOfRounds; round++) {
            playARound();
            printer.printCurrent(carList);
        }
    }

    RacingCarPlayer() {
        configurations = new Configurations();
        advancingMachine = new AdvancingMachine(configurations.getControlValue(), configurations.getMovingDistance());
        scanner = new Scanner(configurations);
        printer = new Printer();
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
}
