package racingcar.view;

import static racingcar.constant.OutputStringConstant.INIT_SHOW_RESULT;
import static racingcar.constant.OutputStringConstant.SHOW_WINNER;

import racingcar.manager.Names;

public class Output {

    public void printGameResultInit() {
        System.out.println(INIT_SHOW_RESULT.getValue());
    }

    public void printRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public void printWinner(Names names) {
        String winnerNames = String.join(", ", names.names());
        System.out.println(SHOW_WINNER.getValue() + winnerNames);
    }
}
