package racingcar.controller;

import racingcar.domain.CarRacing;
import racingcar.domain.CarRacingImp;
import racingcar.view.InputView;
import racingcar.view.OutView;

public class RacingCarController {
    public static void run() {
        CarRacing carRacing = new CarRacingImp();

        OutView.printCarNames();
        carRacing.addCar(InputView.promptForCarNames());

        OutView.printNumberOfAttempts();
        carRacing.addNumberOfRace(InputView.promptNumberOfAttempts());

        OutView.printResults();
        OutView.printRaceResults(carRacing.start());

        OutView.printFinalWinner(carRacing.getWinner());

    }

}
