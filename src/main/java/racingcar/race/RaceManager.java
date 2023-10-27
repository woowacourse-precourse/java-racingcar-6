package racingcar.race;

import racingcar.configuration.AppConfig;
import racingcar.model.AttemptNumber;
import racingcar.view.Output;

public class RaceManager {

    private static final String RESULT_MESSAGE = "실행 결과";

    private final RaceCars carList;
    private final AttemptNumber attemptNumber;

    public RaceManager() {
        this.carList = new RaceCars(AppConfig.getNamesInput());
        this.attemptNumber = new AttemptNumber(AppConfig.getAttemptInput());
    }

    public void startRace() {
        Output.printMessage(RESULT_MESSAGE);

        for (int i = 0; i < attemptNumber.getAttemptNumber(); i++) {
            carList.moveForwardEach();
            Output.printAllCar(carList.getIterator());
        }

        printWinner();
    }

    private void printWinner() {
        RaceWinnerList winnerList = new RaceWinnerList(carList);
        Output.printWinner(winnerList.getIterator());
    }

    @Override
    public String toString() {
        return carList.toString();
    }
}
