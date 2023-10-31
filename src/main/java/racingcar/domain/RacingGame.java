package racingcar.domain;

import racingcar.message.GameMessage;
import racingcar.util.CarGenerator;
import racingcar.util.RacingSimulator;
import racingcar.view.OutputView;
import racingcar.view.Inputview;

import java.util.List;

public class RacingGame {

    public void start() {
        printRequestNames();
        List<Car> cars = generateCars();
        printRequestNumber();
        RacingSimulator simulator = new RacingSimulator(Integer.parseInt(Inputview.consoleLine()));
        System.out.println();
        printStartResult();

        while (simulator.checkZero()) {
            simulator.playSimulator(cars);
            printSimulationResult(cars);
            simulator.minusNumber();
        }

        System.out.println();

        List<Integer> winnerList = simulator.checkWinner();
        printWinner(winnerList, cars);
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
        return carGenerator.generateCars();
    }

    private void printSimulationResult(List<Car> cars) {
        for (Car car : cars) {
            car.printResult();
        }
        System.out.println();
    }

    private void printWinner(List<Integer> winnerNumber, List<Car> cars) {

        if (winnerNumber.size() == 1) {
            OutputView.consoleLine(GameMessage.INSERT_GAME_RESULT_MESSAGE);
            cars.get(winnerNumber.get(0));
        } else if (winnerNumber.size() > 1) {
            for (int i = 0; i < winnerNumber.size() - 1; i++) {
                OutputView.consoleLine(GameMessage.INSERT_GAME_RESULT_MESSAGE);
                cars.get(winnerNumber.get(i));
            }
            cars.get(winnerNumber.get(winnerNumber.size()));
        }
    }
}



