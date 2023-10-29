package racingcar.view;

import java.util.List;

import racingcar.dto.RacingResult;

public class OutputView {
    private static final String DELIMITER = ", ";

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<RacingResult> racingResults) {
        racingResults.forEach(result ->
                System.out.printf("%s : %s%n", result.name(), result.position())
        );
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(DELIMITER, winners));
    }
}
