package racingcar;

import racingcar.ui.input.CarNamesInputReader;
import racingcar.ui.input.NumberOfMovementInputReader;
import racingcar.playrule.RandomNumberRacingRule;
import racingcar.racing.RacingManager;
import racingcar.racingcar.RacingParticipants;
import racingcar.ui.result.ResultViewer;

public class Application {
    public static void main(String[] args) {
        CarNamesInputReader carNamesInputReader = new CarNamesInputReader();
        NumberOfMovementInputReader numberOfMovementInputReader = new NumberOfMovementInputReader();

        RacingManager racingManager = new RacingManager(
                new RacingParticipants(carNamesInputReader.readLine()),
                numberOfMovementInputReader.readLine(),
                new RandomNumberRacingRule()
        );

        ResultViewer resultViewer = new ResultViewer(racingManager);

        resultViewer.printResult();
        while (!racingManager.isEnd()) {
            racingManager.processRacing();
            resultViewer.printCurrentPositions();
        }

        resultViewer.printWinner();

    }
}
