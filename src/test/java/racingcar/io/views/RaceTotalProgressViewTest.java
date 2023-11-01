package racingcar.io.views;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.ConsoleTestSuper;
import racingcar.generic.LapProgress;
import racingcar.generic.RaceTotalProgress;
import racingcar.generic.RacerProgress;

class RaceTotalProgressViewTest extends ConsoleTestSuper {

    @Test
    void announceRacingRecordOn으로_경기전체기록을볼수있음() {
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
        RaceTotalProgressView raceTotalProgressView = new RaceTotalProgressView();

        String expectOutput = """
                실행 결과
                최길동 : ---
                금길동 : -----
                고길동 : -------
                                
                최길동 : ---
                금길동 : ------
                고길동 : -------
                                
                최길동 : ----
                금길동 : ------
                고길동 : -------           
                """;
        raceTotalProgressView.announceRacingRecordOn(raceTotalProgress);

        assertThat(outputStream.toString()).isEqualTo(expectOutput);
    }

    @Test
    void announceWinnersOn으로_경주의우승자를조회할수있음() {
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
                new RacerProgress("금길동", 7),
                new RacerProgress("고길동", 7)));
        RaceTotalProgress raceTotalProgress = new RaceTotalProgress(List.of(firstLap, secondLap, lastLap));
        RaceTotalProgressView raceTotalProgressView = new RaceTotalProgressView();

        String expectOutput = """
                                
                최종 우승자 : 금길동, 고길동       
                """;
        raceTotalProgressView.announceWinnersOn(raceTotalProgress);

        assertThat(outputStream.toString()).isEqualTo(expectOutput);
    }

}