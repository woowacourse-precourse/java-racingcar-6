package racingcar;

import java.util.List;

public class OutputView {

    private static final String RACING_RESULT = "실행 결과";
    private static final String MOVE_LINE = "-";
    private static final String CAR_NAME_MOVE_LINE_TEMPLATE = "%s : %s";

    public void showRacingResult(List<RacingRoundResult> racingResults) {
        println(RACING_RESULT);
        for (RacingRoundResult racingResult : racingResults) {
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

    private void println(String message) {
        System.out.println(message);
    }
}
