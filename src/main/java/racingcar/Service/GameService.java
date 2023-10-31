package racingcar.Service;

import racingcar.View.OutputView;
import racingcar.View.InputView;
import racingcar.Model.Car;
import racingcar.Model.Racing;

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

}
