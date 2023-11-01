package racingcar.view;

import static racingcar.consts.ViewConstant.DELIMITER;
import static racingcar.consts.ViewConstant.NUMBER_OF_ATTEMPT_PROMPT_MESSAGE;
import static racingcar.consts.ViewConstant.RACING_CAR_PROMPT_MESSAGE;
import static racingcar.consts.ViewConstant.RUN_RESULT_PRINT_MESSAGE;
import static racingcar.consts.ViewConstant.WINNER_PRINT_MESSAGE;

import java.util.List;

public class OutputView {
    public void printCarNamePrompt() {
        System.out.println(RACING_CAR_PROMPT_MESSAGE.get());
    }

    public void printNumberOfAttemptPrompt() {
        System.out.println(NUMBER_OF_ATTEMPT_PROMPT_MESSAGE.get());
    }

    public void printResultMessage() {
        System.out.println(RUN_RESULT_PRINT_MESSAGE.get());
    }

    public void printRoundResult(List<String> result) {
        result.forEach(System.out::println);
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.println(WINNER_PRINT_MESSAGE.get() + String.join(DELIMITER.get() + " ", winners));
    }
}
