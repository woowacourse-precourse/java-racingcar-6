package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Map;

public class RacingCarGame {
    public static void playGame() {
        Map<String, Integer> racingCar = RacingCar.saveRacingCar();
        Integer NumberOfGames = Integer.parseInt(InputView.getNum());
        OutputView.printOutputMessage();
        for (int i = 0; i < NumberOfGames; i++) {
            ForwardCar.forwardCar(racingCar);
            printResult(racingCar);
        }
        OutputView.printWinner(CalculatorWinner.winner(racingCar));
    }

    public static void printResult(Map<String, Integer> racingCar) {
        for (String carName : racingCar.keySet()) {
            OutputView.printResult(carName, racingCar.get(carName));
        }
        System.out.println("");
    }
}
