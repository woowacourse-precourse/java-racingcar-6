package racingcar.view;

import racingcar.constant.InformationResponse;
import racingcar.model.Game;

public class OutputView {

    public void printGameStatus(Game game) {
        System.out.println(game);
    }

    public void printWinner(String winner) {
        System.out.println(InformationResponse.WINNER.getMessage() + winner);
    }
}
