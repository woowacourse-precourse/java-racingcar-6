package racingcar.view;

import java.util.List;
import racingcar.model.CarState;

public class OutputView {
    private static final String RACING_ANNOUNCEMENT = "실행 결과";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String POSITION_INDICATOR = "-";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";

    public void printRacingAnnouncement() {
        System.out.println();
        System.out.println(RACING_ANNOUNCEMENT);
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
                + convertForwardCountToPosition(carState.forwardCount());
    }

    private String convertForwardCountToPosition(int forwardCount) {
        return POSITION_INDICATOR.repeat(forwardCount);
    }
}
