package racingcar.view;

import java.util.List;
import racingcar.consts.ViewConstant;

public class OutputView {
    public void printCarNamePrompt() {
        System.out.println(ViewConstant.RACING_CAR_PROMPT_MESSAGE.get());
    }

    public void printNumberOfAttemptPrompt() {
        System.out.println(ViewConstant.NUMBER_OF_ATTEMPT_PROMPT_MESSAGE.get());
        ;
    }

    public void printResultMessage() {
        System.out.println(ViewConstant.RUN_RESULT_PRINT_MESSAGE.get());
    }

    public void printResultRound(List<String> result) {
        result.forEach(System.out::println);
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.println(
                ViewConstant.WINNER_PRINT_MESSAGE.get() + String.join(ViewConstant.DELIMITER.get() + " ", winners));
    }
}
