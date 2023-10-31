package racingcar.view;

public class RacingGameView {

    public void raceStartMessage() {
        System.out.println(RacingGameMessage.START_MESSAGE.getStartMessage());
    }

    public void raceCountMessage() {
        System.out.println(RacingGameMessage.REQUEST_TRY_MESSAGE.getRequestTryMessage());
    }

    public void raceResults(String raceResult) {
        System.out.println(RacingGameMessage.GAME_RESULT_MESSAGE.getGameResultMessage(raceResult));
    }

    public void gameWinners(String winners) {
        System.out.println(RacingGameMessage.WINNER_MESSAGE.getWinnerMessage(winners));
    }
}
