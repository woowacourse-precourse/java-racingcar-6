package racingcar.view;

import static racingcar.view.ViewConstant.ATTEMPT_NUMBER_INPUT;
import static racingcar.view.ViewConstant.CAR_MOVE;
import static racingcar.view.ViewConstant.CAR_NAME_INPUT;
import static racingcar.view.ViewConstant.WINNER;

public class RacingView {

    public static void carNameInputView() {
        System.out.println(CAR_NAME_INPUT);
    }

    public static void attemptNumberInputView() {
        System.out.println(ATTEMPT_NUMBER_INPUT);
    }

    public static void carMoveOrStopDecisionResultView(String carName, int cartPosition) {
        System.out.println(carName + " : " + CAR_MOVE.repeat(cartPosition));
    }

    public static void newLine() {
        System.out.println();
    }

    public static void winnerView(String winner) {
        System.out.println(WINNER + winner);
    }
}
