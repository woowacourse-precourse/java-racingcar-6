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

    public String formatFinalResult(List<RacingResult> racingFinalResultList) {
        int maxDistance = racingFinalResultList.stream()
                .mapToInt(RacingResult::distanceDriven)
                .max()
                .orElse(0);

        List<String> winners = racingFinalResultList.stream()
                .filter(r -> r.distanceDriven() == maxDistance)
                .map(RacingResult::carName)
                .toList();

        return "최종 우승자 : " + String.join(", ", winners);
    }
}
