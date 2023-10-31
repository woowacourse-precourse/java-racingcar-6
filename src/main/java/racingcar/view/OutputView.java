package racingcar.view;

import java.util.Map;
import racingcar.constants.OutputMessages;

public class OutputView {
    public void requestCarNames() {
        System.out.println(OutputMessages.REQUEST_CAR_NAMES.getMessage());
    }

    public void requestTryCount() {
        System.out.println(OutputMessages.REQUEST_TRY_COUNT.getMessage());
    }

    public void printStartResult() {
        System.out.println(OutputMessages.START_RESULT.getMessage());
    }

    public void printRacingStatus(Map<String, Integer> racingStatus) {
        StringBuilder racingStatusMessage = new StringBuilder();

        for (String carName : racingStatus.keySet()) {
            int countOfMove = racingStatus.get(carName);
            racingStatusMessage
                    .append(carName)
                    .append(" : ")
                    .append("-".repeat(countOfMove))
                    .append(System.lineSeparator());
        }
        System.out.println(racingStatusMessage);
    }

    public void printResult(String topRacers) {
        System.out.println(OutputMessages.FINAL_WINNER.getMessage() + topRacers);
    }
}