package racingcar.result;

import java.util.List;

public class RacingCarResultFormatter {

    public String formatRoundResult(List<RacingResult> racingRoundResultList) {
        StringBuilder result = new StringBuilder();
        for (RacingResult racingRoundResult : racingRoundResultList) {
            result.append(racingRoundResult.carName()).append(" : ");
            result.append("-".repeat(Math.max(0, racingRoundResult.distanceDriven())));
            result.append("\n");
        }
        return result.append("\n").toString();
    }
}
