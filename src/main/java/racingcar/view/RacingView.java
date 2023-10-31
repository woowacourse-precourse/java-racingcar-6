package racingcar.view;

import static racingcar.view.constant.ViewConstant.ATTEMPT_NUMBER_INPUT;
import static racingcar.view.constant.ViewConstant.CAR_MOVE;
import static racingcar.view.constant.ViewConstant.CAR_NAME_INPUT;
import static racingcar.view.constant.ViewConstant.RESULT_VIEW;
import static racingcar.view.constant.ViewConstant.WINNER;

public class RacingView {

    public static void inputCarNameView() {
        System.out.println(CAR_NAME_INPUT);
    }

    public static void inputAttemptNumberView() {
        System.out.println(ATTEMPT_NUMBER_INPUT);
    }

    public static void executionResultView() {
        System.out.println(RESULT_VIEW);
    }

    public static void raceResultView(String carName, int cartPosition) {
        System.out.println(carName + " : " + CAR_MOVE.repeat(cartPosition));
    }

    public static void newLine() {
        System.out.println();
    }

    public static void winnerView(String winner) {
        System.out.println(WINNER + winner);
    }
}
