package racingcar.view;

import racingcar.constants.Messages;

public class RacingWinnersOutputView {
    public static void output(String racingWinners) {

        System.out.printf(Messages.RACING_WINNERS_OUTPUT.show(), racingWinners);
    }
}
