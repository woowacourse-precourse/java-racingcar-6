package racingcar.generic;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RaceTotalProgressTest {

    @Test
    void 공동우승자가있을때_decideWinner는_두명의승자를반환한다() {
        String[] expected = {"금길동", "고길동"};
        LapProgress firstLap = new LapProgress(List.of(
                new RacerProgress("최길동", 3),
                new RacerProgress("금길동", 5),
                new RacerProgress("고길동", 7)));
        LapProgress secondLap = new LapProgress(List.of(
                new RacerProgress("최길동", 3),
                new RacerProgress("금길동", 6),
                new RacerProgress("고길동", 7)));
        LapProgress lastLap = new LapProgress(List.of(
                new RacerProgress("최길동", 3),
                new RacerProgress("금길동", 7),
                new RacerProgress("고길동", 7)));
        RaceTotalProgress raceTotalProgress = new RaceTotalProgress(List.of(firstLap, secondLap, lastLap));

        Winners winners = raceTotalProgress.decideWinner();

        Assertions.assertThat(winners.winners()).containsOnly(expected);
    }

    @Test
    void 단독우승자가있을때_decideWinner는_한명의승자를반환한다() {
        String[] expected = {"고길동"};
        LapProgress firstLap = new LapProgress(List.of(
                new RacerProgress("최길동", 3),
                new RacerProgress("금길동", 5),
                new RacerProgress("고길동", 7)));
        LapProgress secondLap = new LapProgress(List.of(
                new RacerProgress("최길동", 3),
                new RacerProgress("금길동", 6),
                new RacerProgress("고길동", 7)));
        LapProgress lastLap = new LapProgress(List.of(
                new RacerProgress("최길동", 4),
                new RacerProgress("금길동", 6),
                new RacerProgress("고길동", 7)));
        RaceTotalProgress raceTotalProgress = new RaceTotalProgress(List.of(firstLap, secondLap, lastLap));

        Winners winners = raceTotalProgress.decideWinner();

        Assertions.assertThat(winners.winners()).containsOnly(expected);
    }

}