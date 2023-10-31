package racingcar.view;

import racingcar.model.RacingCar;
import java.util.List;

public class RacingGameView {

    public void startMessage() {
        System.out.println(GameMessage.START_MESSAGE.getStartMessage());
    }

    public void tryCountMessage() {
        System.out.println(GameMessage.REQUEST_TRY_MESSAGE.getRequestTryMessage());
    }

    public void gameResultMessage() {
        System.out.println("\n" + GameMessage.GAME_RESULT_MESSAGE.getGameResultMessage());
    }

    public void gameResults(String gameResult) {
        System.out.println(gameResult);
    }

    public void gameWinners(List<String> winner) {
        String winners = String.join(", ", winner);
        System.out.println(GameMessage.WINNER_MESSAGE.getWinnerMessage(winners));
    }

}
