package racingcar.controller;

import racingcar.domain.RacingCarRound;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingCarController {
    public void start() {
        initializeRacingGame();
    }

    private void initializeRacingGame() {
        RacingCars racingCars = new RacingCars(InputView.racingCarNameInput());
        RacingCarRound racingCarRound = new RacingCarRound(InputView.attemptNumberInput());
        startRacingCarGame(racingCars, racingCarRound);
    }

    public void startRacingCarGame(RacingCars racingCars, RacingCarRound racingCarRound){
        OutputView.printResultMessage();
        executeRacingCarRound(racingCars, racingCarRound);
        winnerRacingCar(racingCars);
    }
    private void executeRacingCarRound(RacingCars racingCars, RacingCarRound racingCarRound) {
        do {
            racingCarRound.roundStart();
            racingCars.moveRacingCar();
            printRacingCar(racingCars);
        }
        while (racingCarRound.isGameState());
    }

    private void winnerRacingCar(RacingCars racingCars){
        OutputView.printWinner(racingCars.getWinner());
    }
    private void printRacingCar(RacingCars racingCars){
        OutputView.printMoveRacingCar(racingCars);

    }


}
