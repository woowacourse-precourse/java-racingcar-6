package racingcar.view;

import racingcar.dto.RaceResult;

import java.util.List;

public class OutputView {

    private static final String ONE_STEP = "-";
    private static final String PRINT_RACE_RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_WINNERS_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_LIST_DELIMITER = ", ";

    public void printRaceResult(List<RaceResult> raceResults) {
        System.out.println();
        System.out.println(PRINT_RACE_RESULT_MESSAGE);
        raceResults.forEach(this::printRaceStatus);
    }

    private void printRaceStatus(RaceResult raceResult) {
        raceResult.carStatuses().forEach(carStatus -> {
            String carMovementVisualString = createCarMovementVisualString(carStatus.position());
            System.out.println(carStatus.carName() + " : " + carMovementVisualString);
        });
        System.out.println();
    }

    private String createCarMovementVisualString(int carPosition) {
        return ONE_STEP.repeat(carPosition);
    }

    public void printWinners(List<String> winners) {
        String winnerList = String.join(WINNER_LIST_DELIMITER, winners);
        System.out.println(PRINT_WINNERS_MESSAGE + winnerList);
    }
}
