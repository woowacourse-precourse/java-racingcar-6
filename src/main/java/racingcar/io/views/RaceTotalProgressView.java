package racingcar.io.views;

import java.util.stream.Collectors;
import racingcar.generic.RaceTotalProgress;
import racingcar.generic.Winners;
import racingcar.io.Output;

public class RaceTotalProgressView {

    public void announceRacingRecordOn(RaceTotalProgress totalProgress) {
        Output.consoleLine("실행 결과");
        String totalProgressRecord = totalProgress.stream()
                .map(lap ->
                        lap.stream()
                                .map(racer -> racer.name() + " : " + "-".repeat(racer.mileage()))
                                .collect(Collectors.joining(System.lineSeparator())))
                .collect(Collectors.joining(System.lineSeparator().repeat(2)));
        Output.consoleLine(totalProgressRecord);
    }

    public void announceWinnersOn(RaceTotalProgress totalProgress) {
        Winners winners = totalProgress.decideWinner();
        String totalWinners = winners.stream()
                .collect(Collectors.joining(", "));
        Output.consoleLine(System.lineSeparator() + "최종 우승자 : " + totalWinners);
    }

}
