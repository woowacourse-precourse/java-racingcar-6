package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.RacingGameMessage;

public class RacingGameView {

    public String getInputLine() {
        return Console.readLine();
    }

    public void raceStartMessage() {
        System.out.println(RacingGameMessage.START_MESSAGE.getStartMessage());
    }

    public void raceCountMessage() {
        System.out.println(RacingGameMessage.REQUEST_RACE_COUNT_MESSAGE.getRequestRaceCountMessage());
    }

    public void raceResults(final String raceResult) {
        System.out.println(RacingGameMessage.GAME_RESULT_MESSAGE.getRaceResultMessage(raceResult));
    }

    public void winners(final String winners) {
        System.out.println(RacingGameMessage.WINNER_MESSAGE.getWinnerMessage(winners));
    }
}
