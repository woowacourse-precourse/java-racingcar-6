package racingcar.view;

import java.util.List;
import racingcar.model.CarDto;

public class OutputView {
    private static final String RESULT_ANNOUNCEMENT = "실행 결과";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String POSITION_INDICATOR = "-";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";

    public void printResultAnnouncement() {
        System.out.println();
        System.out.println(RESULT_ANNOUNCEMENT);
    }

    public void printAllCarPosition(List<CarDto> carDtos) {
        carDtos.stream()
                .map(this::formatCarPosition)
                .forEach(System.out::println);
        System.out.println();
    }

    public void printWinnerCar(List<String> names) {
        System.out.println(WINNER_ANNOUNCEMENT + String.join(", ", names));
    }

    private String formatCarPosition(CarDto carDto) {
        return carDto.getName()
                + NAME_POSITION_DELIMITER
                + convertMoveCountToPosition(carDto.getMoveCount());
    }

    private String convertMoveCountToPosition(int moveCount) {
        return POSITION_INDICATOR.repeat(moveCount);
    }
}
