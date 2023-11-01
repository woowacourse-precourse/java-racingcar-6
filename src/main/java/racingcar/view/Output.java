package racingcar.view;

import static racingcar.constant.OutputStringConstant.INIT_SHOW_RESULT;
import static racingcar.constant.OutputStringConstant.OUTPUT_NAME_DIVIDER;
import static racingcar.constant.OutputStringConstant.SHOW_WINNER;

import racingcar.utils.dto.Names;

public class Output {

    public void printGameResultInit() {
        System.out.println(INIT_SHOW_RESULT.getValue());
    }

    public void printRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public void printWinner(Names names) {
        String winnerNames = String.join(OUTPUT_NAME_DIVIDER.getValue(), names.names());
        System.out.println(SHOW_WINNER.getValue() + winnerNames);
    }
}
