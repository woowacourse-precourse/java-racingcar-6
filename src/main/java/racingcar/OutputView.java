package racingcar;

import java.util.List;

public class OutputView {

    private static final String RACING_RESULT = "실행 결과";
    private static final String MOVE_LINE = "-";
    private static final String WINNER_NAMES_TEMPLATE = "최종 우승자: %s";
    private static final String CAR_NAME_MOVE_LINE_TEMPLATE = "%s : %s";
    private static final String COMMA = ", ";

    public void showRacingResult(RacingResult racingResults) {
        println(RACING_RESULT);
        printRacingHistory(racingResults);
        printWinnerNames(racingResults);
    }

    private void printWinnerNames(RacingResult racingResults) {
        String winnerNames = String.join(COMMA, racingResults.winnerNames());
        print(WINNER_NAMES_TEMPLATE.formatted(winnerNames));
    }

    private void printRacingHistory(RacingResult racingResults) {
        for (RacingRoundResult racingResult : racingResults.racingRoundResults()) {
            showRacingRoundResult(racingResult);
        }
    }

    private void showRacingRoundResult(RacingRoundResult roundResult) {
        for (CarStatus carStatus : roundResult.carStatuses()) {
            showCarStatus(carStatus);
        }
        println("");
    }

    private void showCarStatus(CarStatus carStatus) {
        String line = MOVE_LINE.repeat(carStatus.position());
        println(CAR_NAME_MOVE_LINE_TEMPLATE.formatted(carStatus.name(), line));
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
