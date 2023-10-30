package racingcar.domain.result;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.winner.Winners;

public record RacingGameStatistics(List<RacingCarResult> racingCarResults) {

    private static final String NO_MAXIMUM = "최대 값이 없습니다.";

    public List<String> getStatisticsMessages() {
        return racingCarResults.stream().map(RacingCarResult::getResultMessage).collect(Collectors.toList());
    }

    public Winners getWinners() {
        Integer bestLocation = getBestLocation();
        List<String> winnerNames = selectWinnerWithBestPosition(bestLocation);
        return new Winners(winnerNames);
    }

    private Integer getBestLocation() {
        return racingCarResults.stream().max(Comparator.comparing(RacingCarResult::location))
                .map(RacingCarResult::location)
                .orElseThrow(() -> new IllegalArgumentException(NO_MAXIMUM));
    }

    private List<String> selectWinnerWithBestPosition(Integer bestPosition) {
        return racingCarResults.stream().filter(racingCarResult -> bestPosition.equals(racingCarResult.location()))
                .map(RacingCarResult::name).collect(Collectors.toList());
    }
}
