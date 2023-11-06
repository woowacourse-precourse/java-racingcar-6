package racingcar.view;

import java.util.List;
import racingcar.model.CarPosition;

public class GameScreen {

    private static final String GAME_PROGRESS_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

    public void displayGameProgressMessage() {
        System.out.println();
        System.out.println(GAME_PROGRESS_MESSAGE);
    }

    public void displayCurrentRacingCarsPosition(List<CarPosition> currentRacingCarPositions) {
        String currentRacingCarsPosition = RacingCarsPositionStringBuilder
            .buildCurrentRacingCarsPosition(currentRacingCarPositions);

        System.out.println(currentRacingCarsPosition);
        System.out.println();
    }

    public void displayWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE_PREFIX + joinWinners(winners));
    }

    private String joinWinners(List<String> winners) {
        return String.join(", ", winners);
    }
}
