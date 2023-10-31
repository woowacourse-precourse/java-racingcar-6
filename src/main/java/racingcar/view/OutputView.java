package racingcar.view;

import racingcar.constant.InformationResponse;
import racingcar.model.GameScore;

public class OutputView {

    public void printGameScore(GameScore gameScore){
        System.out.println(gameScore);
    }

    public void printWinner(String winner){
        System.out.println(InformationResponse.WINNER.getMessage() + winner);
    }
}
