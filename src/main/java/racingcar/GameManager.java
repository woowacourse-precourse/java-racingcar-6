package racingcar;


import domain.Cars;
import domain.RaceResult;
import domain.RandomNumberStrategy;
import ui.Output;

public class GameManager {
    public void run() {
        RandomNumberStrategy moveStrategy = new RandomNumberStrategy();
        RacingGame racingGame = new RacingGame(moveStrategy);

        Cars cars = receiveCarNames(racingGame);
        RaceResult raceResult = receiveAttemptInput(racingGame, cars);
//        Output.printRaceResult(raceResult);
        Output.printRaceWinner(raceResult);
    }

    public Cars receiveCarNames(RacingGame racingGame) {
        try {
            Output.printRequestCarNamesInput();
            String carNames = camp.nextstep.edu.missionutils.Console.readLine();
            return racingGame.generateCars(carNames);
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());
            return receiveCarNames(racingGame);
        }
    }

    public RaceResult receiveAttemptInput(RacingGame racingGame, Cars cars) {
        try {
            Output.printRequestAttemptNumberInput();
            String AttemptInput = camp.nextstep.edu.missionutils.Console.readLine();
            return racingGame.startRace(AttemptInput, cars);
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());
            return receiveAttemptInput(racingGame, cars);
        }
    }

}
