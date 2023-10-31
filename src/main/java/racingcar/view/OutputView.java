package racingcar.view;

import racingcar.model.GameScore;

public class OutputView {

    public void printGameScore(GameScore gameScore){
        System.out.println(gameScore);
    }

    public void printWinner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }
}
