package racingcar.view;

import static racingcar.view.messages.Messages.GAME_RESULT_GUIDE;
import static racingcar.view.messages.Messages.INPUT_CAR_NAMES_GUIDE;
import static racingcar.view.messages.Messages.INPUT_TRY_COUNT_GUIDE;
import static racingcar.view.messages.Messages.WINNERS_GUIDE;

public class OutputView {
    public static void displayCarNames() {
        System.out.println(INPUT_CAR_NAMES_GUIDE.getMessage());
    }

    public static void displayTryCount() {
        System.out.println(INPUT_TRY_COUNT_GUIDE.getMessage());
    }

    public static void displayGameResultMessage() {
        System.out.println(GAME_RESULT_GUIDE.getMessage());
    }

    public static void displayGameResult(String gameResult) {
        System.out.println(gameResult);
    }

    public static void displayWinners(String winners) {
        System.out.println(WINNERS_GUIDE.getMessage() + winners);
    }
}
