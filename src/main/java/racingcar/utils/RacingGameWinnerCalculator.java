package racingcar.utils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.result.RacingCarResult;

public class RacingGameWinnerCalculator {

    private static final int FIRST_RANK = 0;

    public static List<String> getWinners(List<RacingCarResult> results) {
        Integer bestPosition = getBestPosition(results);
        return selectWinnerWithBestPosition(bestPosition, results);
    }

    private static List<String> selectWinnerWithBestPosition(Integer bestPosition, List<RacingCarResult> results) {
        return results.stream().filter(racingCarResult -> bestPosition.equals(racingCarResult.location()))
                .map(RacingCarResult::name).collect(Collectors.toList());
    }

    private static Integer getBestPosition(List<RacingCarResult> results) {
        results.sort(Comparator.comparing(RacingCarResult::location).reversed());
        RacingCarResult bestResult = results.get(FIRST_RANK);
        return bestResult.location();
    }
}
