package racingcar.race;

import racingcar.AttemptNumber;
import racingcar.view.AttemptInput;
import racingcar.view.NamesInput;
import racingcar.view.Output;

public class RaceManager {

    private static final String RESULT_MESSAGE = "실행 결과";

    private final RaceCars carList;
    private final AttemptNumber attemptNumber;

    public RaceManager() {
        this.carList = new RaceCars(new NamesInput());
        this.attemptNumber = new AttemptNumber(new AttemptInput());
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
