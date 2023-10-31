package racingcar.view;

import racingcar.constants.Messages;

public class MessageOutputView {

    public static void outputRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public static void outputRacingWinners(String racingWinners) {

        System.out.printf(Messages.RACING_WINNERS_OUTPUT.show(), racingWinners);
    }

}
