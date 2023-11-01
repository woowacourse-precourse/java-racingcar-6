package racingcar.service;

import static racingcar.constant.OutputConstant.RACING_RESULT;
import static racingcar.constant.OutputConstant.WINNERS;
import static racingcar.service.GameService.racingResult;

import java.util.ArrayList;
import java.util.List;

public class OutputService {
    public static void setOutputMessage() {
        System.out.println("\n" + RACING_RESULT);
    }

    public static void gameResultMessage(List<String> candidates) {
        List<String> winners = new ArrayList<>();

        String winner = candidates.get(0);

        String firstScore = racingResult.get(winner);

        for (String candidate : candidates) {
            if (racingResult.get(candidate).length() == firstScore.length()) {
                winners.add(candidate);
            }
        }

        String sWinners = String.join(", ", winners);

        System.out.println(WINNERS + sWinners);
    }
}
