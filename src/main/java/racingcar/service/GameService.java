package racingcar.service;

import racingcar.view.OutputView;
import racingcar.view.InputView;
import racingcar.model.Car;
import racingcar.model.Racing;

import java.util.List;

public class GameService {
    private static List<String> carNameList;
    private static int numberOfAttempts;
    private static final Racing racing = new Racing();

    public static void startRacingCar() {
        OutputView.printStartMessage();
        carNameList = InputView.getCarNameList();

        OutputView.printNumberOfAttemptsMessage();
        numberOfAttempts = InputView.getNumberOfAttempts();
        System.out.println();
    }

    public static void playRacingCar() {
        OutputView.printExecutionResultMessage();
        racing.UpdateCars(carNameList);

        for(int i = 0; i < numberOfAttempts; i++)
        {
            racing.progressCarRacing();
            OutputView.printExecutionMessage(racing.getRacingCar());
        }
    }

    public static void endRacingCar() {
        List<String> winnerList = Racing.getWinner();
        OutputView.printWinnerMessage(winnerList);
    }

}
