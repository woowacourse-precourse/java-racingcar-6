package racingcar.view;

import java.util.List;
import racingcar.model.CarState;

public class OutputView {
    private static final String RESULT_ANNOUNCEMENT = "실행 결과";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String POSITION_INDICATOR = "-";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";

    public void printResultAnnouncement() {
        System.out.println();
        System.out.println(RESULT_ANNOUNCEMENT);
    }

    public void printAllCarPositionByState(List<CarState> carStates) {
        carStates.stream()
                .map(this::formatCarPositionByState)
                .forEach(System.out::println);
        System.out.println();
    }

    public void printWinnerCar(List<String> names) {
        System.out.println(WINNER_ANNOUNCEMENT + String.join(", ", names));
    }

    private String formatCarPositionByState(CarState carState) {
        return carState.name()
                + NAME_POSITION_DELIMITER
                + convertMoveCountToPosition(carState.moveCount());
    }

    private String convertMoveCountToPosition(int moveCount) {
        return POSITION_INDICATOR.repeat(moveCount);
    }
}
