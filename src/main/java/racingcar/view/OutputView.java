package racingcar.view;

import racingcar.constants.MessageConstants;
import racingcar.model.Race;

import java.util.List;

import static racingcar.util.StringUtil.convertToString;

public class OutputView {
    public void printExecutionResultMessage(List<String> executionResults) {
        String message = convertToString(executionResults);
        System.out.println(MessageConstants.EXECUTION_RESULT_MESSAGE + "\n" + message);
    }

    public void printWinnerResultMessage(Race race) {
        String message = race.toString(race.getWinners());
        System.out.println(MessageConstants.WINNER_ANNOUNCEMENT_MESSAGE + message);
    }
}
