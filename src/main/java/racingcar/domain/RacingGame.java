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
            RacingSimulator simulator = new RacingSimulator(Inputview.consoleLine());
            simulator.checkNumberValidation();
            simulator.invertStringToInt();

            System.out.println();
            printStartResult();


            while (simulator.checkZero()) {
                simulator.playSimulator(cars);
                printSimulationResult(cars);
                simulator.minusNumber();
            }

            List<Integer> winnerList = simulator.checkMaxKey();


            System.out.println();

            WinnerCalculator winnerCalculator = new WinnerCalculator(cars, winnerList);






    }

    private void printRequestNames() {
        OutputView.consoleLine(GameMessage.INSERT_NAME_MESSAGE);
    }

    private void printRequestNumber() {
        OutputView.consoleLine(GameMessage.INSERT_TURN_MESSAGE);
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

    private void printSimulationResult(List<Car> cars) {
        for (Car car : cars) {
            car.printResult();

        }
        System.out.println();
    }

    private void printWinner(List<Integer> winnerNumber, List<Car> cars) {
        OutputView.console(GameMessage.INSERT_GAME_RESULT_MESSAGE);
        if (winnerNumber.size() == 1) {
            Car winner = cars.get(winnerNumber.get(0));
            winner.printName();
        } else if (winnerNumber.size() > 1) {
            for (int i = 0; i < winnerNumber.size() - 1; i++) {
                Car winner = cars.get(winnerNumber.get(i));
                winner.printName();
                OutputView.console(GameMessage.INSERT_REST_MULTIPLE_WINNER);
            }
            cars.get(winnerNumber.get(winnerNumber.size()));
        }
    }
}



