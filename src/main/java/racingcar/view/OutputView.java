package racingcar.view;

import static racingcar.util.Messages.*;

public class OutputView {
    public static void printInputCarName() {
        System.out.println(INPUT_CAR_NAME);
    }

    public static void printInputRacingCount() {
        System.out.println(INPUT_RACING_COUNT);
    }

    public static void printStartRacing() {
        System.out.println(RACING_RESULT);
    }

    public static void printFinalWinner(String winners) {
        System.out.println(FINAL_WINNER + winners);
    }
}
