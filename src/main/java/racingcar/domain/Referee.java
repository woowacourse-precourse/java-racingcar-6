package racingcar.domain;

import java.util.List;

public class Referee {

    public Referee() {
    }

    public void announceWinner(ScoreBoard scoreBoard) {
        List<String> winners = scoreBoard.findWinners();
        // 최종 우승자 출력
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
