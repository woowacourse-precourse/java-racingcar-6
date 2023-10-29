package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutView;

public class RacingCarController {
    public static void run() {
        CarRacing carRacing = new CarRacingImp();

        OutView.printCarNames();
        carRacing.addCar(InputView.promptForCarNames());

        OutView.printNumberOfAttempts();
        int NumberOfMatches = InputView.promptNumberOfAttempts();

        for (int i = 0; i <= NumberOfMatches; i++) {
            OutView.printRaceResults(carRacing.progress());
        }

        OutView.printFinalWinner(carRacing.getWinner());

    }

}
