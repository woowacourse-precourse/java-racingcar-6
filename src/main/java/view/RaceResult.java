package view;

import static view.GuideMessage.FINAL_WINNER;

import java.util.List;

public class RaceResult {
    public void showWinners(List<String> winnerNames) {
        String result = String.join(",", winnerNames);

        System.out.print(FINAL_WINNER);
        System.out.println(result);
    }
}