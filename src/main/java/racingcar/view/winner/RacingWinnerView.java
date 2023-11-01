package racingcar.view.winner;

import racingcar.domain.winner.Winners;

public class RacingWinnerView {

    public static void showWinners(Winners winners) {
        System.out.println();
        System.out.println(winners.getWinnersMessage());
    }
}
