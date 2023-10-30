package racingcar.view;

import static racingcar.view.message.GameMessage.CAR_NAME_INPUT_QUESTION_MESSAGE;
import static racingcar.view.message.GameMessage.GAME_RESULT_PREFIX_MESSAGE;
import static racingcar.view.message.GameMessage.TOTAL_ROUND_INPUT_QUESTION_MESSAGE;

public final class OutputView {
    private OutputView() {

    }

    public static void printCarNameInputQuestion() {
        System.out.println(CAR_NAME_INPUT_QUESTION_MESSAGE);
    }

    public static void printTotalRoundInputQuestion() {
        System.out.println(TOTAL_ROUND_INPUT_QUESTION_MESSAGE);
    }

    public static void printGameStartMessage() {
        System.out.println();
        System.out.println(GAME_RESULT_PREFIX_MESSAGE);
    }
}
