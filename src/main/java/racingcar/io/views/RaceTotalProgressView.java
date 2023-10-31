package racingcar.io.views;

import static java.util.stream.Collectors.joining;
import static racingcar.io.enums.RaceTotalProgressViewMessage.BLANK_AND_NEW_LINE;
import static racingcar.io.enums.RaceTotalProgressViewMessage.DELIMITER_WINNERS;
import static racingcar.io.enums.RaceTotalProgressViewMessage.MESSAGE_RACE_RESULT;
import static racingcar.io.enums.RaceTotalProgressViewMessage.NEW_LINE;
import static racingcar.io.enums.RaceTotalProgressViewMessage.makeWinnersMessage;

import racingcar.generic.LapProgress;
import racingcar.generic.RaceTotalProgress;
import racingcar.generic.Winners;
import racingcar.io.Output;
import racingcar.io.enums.RaceTotalProgressViewMessage;

public class RaceTotalProgressView {

    public void announceRacingRecordOn(RaceTotalProgress totalProgress) {
        Output.consoleLine(MESSAGE_RACE_RESULT.get());
        String totalProgressRecord = totalProgress.stream()
                .map(RaceTotalProgressView::makeRacingRecords)
                .collect(joining(BLANK_AND_NEW_LINE.get()));
        Output.consoleLine(totalProgressRecord);
    }

    private static String makeRacingRecords(LapProgress lap) {
        return lap.stream()
                .map(RaceTotalProgressViewMessage::makeRacingRecord)
                .collect(joining(NEW_LINE.get()));
    }

    public void announceWinnersOn(RaceTotalProgress totalProgress) {
        Winners winners = totalProgress.decideWinner();
        String totalWinners = winners.stream()
                .collect(joining(DELIMITER_WINNERS.get()));
        Output.consoleLine(makeWinnersMessage(totalWinners));
    }

}
