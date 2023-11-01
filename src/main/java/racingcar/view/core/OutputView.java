package racingcar.view.core;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RaceGameResult.TrackPerResult;

public final class OutputView extends ConsoleWriter {
    private static final String WINNER_DELIMITER = ", ";

    public void printRaceStartMessage() {
        PrintMessage.PRINT_RACE_RESULT.invoke(this::println);
    }

    public void printTrackPerResult(List<TrackPerResult> trackPerResults) {
        this.println(trackPerResults.stream()
                .map(TrackPerResult::toResult)
                .collect(Collectors.joining("\n"))
        );
        this.newLine();

    }

    public void printWinner(List<String> winners) {
        this.print(String.format("최종 우승자 : %s", String.join(WINNER_DELIMITER, winners)));
    }
}
