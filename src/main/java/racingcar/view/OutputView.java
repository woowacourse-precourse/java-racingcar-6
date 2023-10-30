package racingcar.view;

import java.util.List;
import racingcar.domain.RacingPlayer;

public class OutputView {
    public void outputRaceProgress(List<RacingPlayer> players) {
        for (RacingPlayer player : players) {
            StringBuilder score = new StringBuilder();

            score.append(player.getName()).append(" : ");
            score.append("-".repeat(Math.max(0, player.getScore())));

            System.out.println(score);
        }
        System.out.println();
    }

    public void outputWinners(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
