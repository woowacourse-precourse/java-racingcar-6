package racingcar.view;

public class RacingGameView {

    public void raceStartMessage() {
        System.out.println(GameMessage.START_MESSAGE.getStartMessage());
    }

    public void raceCountMessage() {
        System.out.println(GameMessage.REQUEST_TRY_MESSAGE.getRequestTryMessage());
    }

    public void raceResultMessage() {
        System.out.println(GameMessage.GAME_RESULT_MESSAGE.getGameResultMessage());
    }

    public void raceResults(String gameResult) {
        System.out.println(gameResult);
    }

    public void gameWinners(String winners) {
        System.out.println(GameMessage.WINNER_MESSAGE.getWinnerMessage(winners));
    }
}
