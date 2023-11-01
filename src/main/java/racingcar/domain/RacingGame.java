package racingcar.domain;

import racingcar.message.GameMessage;
import racingcar.util.CarGenerator;
import racingcar.util.RacingSimulator;
import racingcar.util.WinnerCalculator;
import racingcar.view.OutputView;
import racingcar.view.Inputview;

import java.util.List;



public class RacingGame {

    public void start() {

            printRequestNames();
            List<Car> cars = generateCars();

            printRequestNumber();
            RacingSimulator simulator = inputRaceNumber();

            checkValidation(simulator);

            startRacingSimulation(simulator, cars);

            List<Integer> winnerList = simulator.checkMaxKey();


            System.out.println();

            WinnerCalculator winnerCalculator = new WinnerCalculator(cars, winnerList);
            String result = winnerCalculator.makeWinnerString();


            OutputView.consoleLine(result);



    }

    private void printRequestNames() {
        OutputView.consoleLine(GameMessage.INSERT_NAME_MESSAGE);
    }

    private void printRequestNumber() {
        OutputView.consoleLine(GameMessage.INSERT_TURN_MESSAGE);
    }

    private RacingSimulator inputRaceNumber() {
        return new RacingSimulator(Inputview.consoleLine());
    }

    private void printStartResult() {
        OutputView.consoleLine(GameMessage.INSERT_RESULT_MESSAGE);
    }

    private List<Car> generateCars() {
        CarGenerator carGenerator = new CarGenerator(Inputview.consoleLine());
        carGenerator.splitNames();
        carGenerator.checkLengthValidation();
        return carGenerator.generateCars();
    }

    private void startRacingSimulation(RacingSimulator simulator, List<Car> cars){
        System.out.println();
        printStartResult();
        while (simulator.checkZero()) {
            simulator.playSimulator(cars);
            printSimulationResult(cars);
            simulator.minusNumber();
        }
    }

    private void printSimulationResult(List<Car> cars) {
        for (Car car : cars) {
            car.printResult();

        }
        System.out.println();
    }



    private void checkValidation(RacingSimulator simulator){
        simulator.checkNumberValidation();
        simulator.invertStringToInt();
    }
}



