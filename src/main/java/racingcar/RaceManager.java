package racingcar;

import racingcar.configuration.AppConfig;
import racingcar.view.Output;

public class RaceManager {

    private static final String RESULTS_DELIMITER = ", ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

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
            carList.printAllCar();
        }

        printWinner();
    }

    private void printWinner() {
        StringBuilder builder = new StringBuilder();
        for (RaceCar car : carList.getMaximumList()) {
            builder.append(car).append(RESULTS_DELIMITER);
        }

        Output.printMessage(FINAL_WINNER_MESSAGE + builder);
    }

    @Override
    public String toString() {
        return carList.toString();
    }
}
