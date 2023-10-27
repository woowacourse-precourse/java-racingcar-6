package racingcar.view;

import static racingcar.view.ViewConstant.ATTEMPT_NUMBER_INPUT;
import static racingcar.view.ViewConstant.CAR_NAME_INPUT;

public class RacingView {

    public static void carNameInputView() {
        System.out.println(CAR_NAME_INPUT);
    }

    public static void attemptNumberInputView() {
        System.out.println(ATTEMPT_NUMBER_INPUT);
    }

    public static void carMoveOrStopDecisionResultView(String carName, int cartPosition) {
        System.out.println(carName + " : " + "*".repeat(cartPosition));
    }

    public static void winnerView(String winner) {
        System.out.println("최종우승자 : " + winner);
    }
}
