package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<String> findWinners(List<String> carNames, List<String> progressResults) {
        List<String> winner = new ArrayList<>();
        int maxProgress = findMaxProgress(progressResults);

        for (int r = 0; r < progressResults.size(); r++) {
            if(progressResults.get(r).length() == maxProgress) {
                winner.add(carNames.get(r));
            }
        }

        printResult(winner);
        return winner;
    }

    public int findMaxProgress(List<String> progressResults) {
        int maxProgress = 0;

        for (String progressResult: progressResults) {
            if(progressResult.length() > maxProgress) {
                maxProgress = progressResult.length();
            }
        }
        return maxProgress;
    }

    private void printResult(List<String> winner) {
        String result = String.join(",", winner);
        System.out.println("최종 우승자 : " + result);
    }
}
