package racingcar.view.core;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.part.RaceGameComponent.RaceGameResult.TrackPerResult;

public final class OutputView extends ConsoleWriter {
    public void printRaceStartMessage() {
        this.println("실행 결과");
    }

    public void printTrackPerResult(List<TrackPerResult> trackPerResults) {
        this.println(trackPerResults.stream()
                .map((trackPerResult -> String.format("%s : %s", trackPerResult.name(), "-".repeat(trackPerResult.distance()))))
                .collect(Collectors.joining("\n"))
        );
        this.newLine();

    }

    public void printWinner(List<String> winners) {
        this.print("최종 우승자 : ");
        this.print(String.join(",", winners));
    }
}
