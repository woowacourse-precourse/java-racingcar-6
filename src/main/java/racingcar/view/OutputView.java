package racingcar.view;

import java.util.List;

import racingcar.dto.RacingResult;

public class OutputView {
    private static final String DELIMITER = ", ";

    public void printMessage() {
        System.out.println("실행 결과");
    }

    public void printResult(List<RacingResult> racingResults) {
        racingResults.forEach(result ->
                System.out.printf("%s : %s%n", result.name(), result.position())
        );
        System.out.println();
    }
}
